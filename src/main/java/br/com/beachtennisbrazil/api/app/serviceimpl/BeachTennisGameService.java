package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.GameByAppointment;
import br.com.beachtennisbrazil.api.app.entities.validation.BeachTennisGameValidator;
import br.com.beachtennisbrazil.api.app.enums.TypeOfSchedule;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateBeachTennisGameException;
import br.com.beachtennisbrazil.api.app.exceptions.CannotUpdateBeachTennisGameException;
import br.com.beachtennisbrazil.api.app.exceptions.EntityNotFoundException;
import br.com.beachtennisbrazil.api.app.repositories.BeachTennisGameRepository;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.app.service.BeachTennisGameServiceInterface;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
@AllArgsConstructor
public class BeachTennisGameService implements BeachTennisGameServiceInterface {

    @Autowired
    private BeachTennisGameRepository repository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<BeachTennisGame> findAll() {
        return repository.findAll();
    }

    @Override
    public BeachTennisGame findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found exception."));
    }

    @Override
    public void createBeachTennisGame(BeachTennisGame beachTennisGame) {
        try {
            BeachTennisGameValidator gameValidator = new BeachTennisGameValidator();
            var validator = gameValidator.validateIfTheGameCanBeCreated(beachTennisGame);
            beachTennisGame.setStartTime(LocalTime.of(beachTennisGame.getTimeConverter().getHours(), beachTennisGame.getTimeConverter().getMinutes()));
            beachTennisGame.setEndTime(beachTennisGame.getStartTime().plusHours(beachTennisGame.getContractedHours().getHour()).plusMinutes(beachTennisGame.getContractedHours().getMinute()));
            beachTennisGame.setQuantityPlayingNow(beachTennisGame.getGameCodes().size());
            beachTennisGame.setTypeOfSchedule(TypeOfSchedule.RECEPTION);

            gameCodeValidation(beachTennisGame);

            Set<Integer> hashSetGameCodes = new HashSet<>(beachTennisGame.getGameCodes());

            if (hashSetGameCodes.size() == beachTennisGame.getGameCodes().size() && validator == true ? true : false) {
                repository.save(beachTennisGame);
            } else {
                throw new RuntimeException("");
            }


        } catch (Exception err) {
            throw new CannotCreateBeachTennisGameException("Cannot create a game: Please, check the game codes list and try again! " +
                    "Game codes inserted:" + beachTennisGame.getGameCodes() + " " + err.getMessage());
        }
    }

    @Override
    public void createBeachTennisGameByAppointment(GameByAppointment gameByAppointment) {
        try {
            BeachTennisGameValidator gameValidator = new BeachTennisGameValidator();
            var validator = gameValidator.validateIfTheGameCanBeCreated(gameByAppointment);

            if (!gameByAppointment.getAppointmentDate().isBefore(ChronoLocalDate.from(LocalDateTime.now()))) {
                // Criar metodos que facam isto e evitar repeticao
                gameByAppointment.setEndTime(gameByAppointment.getStartTime().plusHours(gameByAppointment.getContractedHours().getHour()).plusMinutes(gameByAppointment.getContractedHours().getMinute()));
                gameByAppointment.setQuantityPlayingNow(gameByAppointment.getGameCodes().size());
                gameByAppointment.setTypeOfSchedule(TypeOfSchedule.SYSTEM);
            }

            gameCodeValidation(gameByAppointment);

            Set<Integer> hashSetGameCodes = new HashSet<>(gameByAppointment.getGameCodes());

            if (hashSetGameCodes.size() == gameByAppointment.getGameCodes().size() && validator == true ? true : false) {
                repository.save(gameByAppointment);
            } else {
                throw new RuntimeException("");
            }


        } catch (Exception err) {
            throw new CannotCreateBeachTennisGameException("Cannot create a game: Please, check the game codes list and try again! " +
                    "Game codes inserted:" + gameByAppointment.getGameCodes() + " " + err.getMessage() + "start: " + gameByAppointment.getStartTime());
        }

    }

    @Override
    public void updateBeachTennisGameData(BeachTennisGame oldBeachTennisGame, BeachTennisGame newBeachTennisGame) {
        oldBeachTennisGame.setGameDate(newBeachTennisGame.getGameDate());
        oldBeachTennisGame.setTypeOfGame(newBeachTennisGame.getTypeOfGame());
        oldBeachTennisGame.setGameCodes(newBeachTennisGame.getGameCodes());
        oldBeachTennisGame.setStartTime(newBeachTennisGame.getStartTime());
        oldBeachTennisGame.setContractedHours(newBeachTennisGame.getContractedHours());
        oldBeachTennisGame.setQuantityPlayingNow(newBeachTennisGame.getQuantityPlayingNow());
        oldBeachTennisGame.setEndTime(newBeachTennisGame.getEndTime());
        oldBeachTennisGame.setId(newBeachTennisGame.getId());
        oldBeachTennisGame.setLoanables(newBeachTennisGame.getLoanables());
    }

    @Override
    public void updateAndSaveBeachTennisGame(UUID id, BeachTennisGame newBeachTennisGame) {
        try {
            BeachTennisGame oldBeachTennisGame = repository.findById(id).get();
            updateBeachTennisGameData(oldBeachTennisGame, newBeachTennisGame);
            updateAndSaveBeachTennisGame(oldBeachTennisGame.getId(), newBeachTennisGame);
            repository.save(newBeachTennisGame);
        } catch (Exception err) {
            throw new CannotUpdateBeachTennisGameException("Captured error: " + err.getMessage());
        }
    }

    @Override
    public void deleteBeachTennisGameById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception err) {
            throw new EntityNotFoundException("Captured error: Game Court ID: " + id + " has not found! " + err.getMessage());
        }
    }

    public boolean gameCodeValidation(BeachTennisGame game) {
        for (int i = 0; i < game.getGameCodes().size(); i++) {
            if (playerRepository.findByGameCode(game.getGameCodes().get(i)).getGameCode() == null ? false : true)
                ;
        }
        return false;
    }
}
