package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.GameWithoutAppointment;
import br.com.beachtennisbrazil.api.app.entities.validation.BeachTennisGameValidator;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateBeachTennisGameException;
import br.com.beachtennisbrazil.api.app.exceptions.CannotUpdateBeachTennisGameException;
import br.com.beachtennisbrazil.api.app.exceptions.EntityNotFoundException;
import br.com.beachtennisbrazil.api.app.repositories.BeachTennisGameRepository;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.app.service.BeachTennisGameServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
    public void createBeachTennisGame(GameWithoutAppointment gameWithoutAppointment) {
        try {
            BeachTennisGameValidator gameValidator = new BeachTennisGameValidator();
            var validator = gameValidator.validateIfTheGameCanBeCreated(gameWithoutAppointment);
            gameWithoutAppointment.setStartTime(LocalTime.of(gameWithoutAppointment.getTimeConverter().getHours(), gameWithoutAppointment.getTimeConverter().getMinutes()));
            gameWithoutAppointment.setEndTime(gameWithoutAppointment.getStartTime().plusHours(gameWithoutAppointment.getContractedHours().getHour()).plusMinutes(gameWithoutAppointment.getContractedHours().getMinute()));
            gameWithoutAppointment.setQuantityPlayingNow(gameWithoutAppointment.getGameCodes().size());

            for (int i = 0; i < gameWithoutAppointment.getGameCodes().size(); i++) {
                if (playerRepository.findByGameCode(gameWithoutAppointment.getGameCodes().get(i)).getGameCode() == null ? false : true)
                    ;
            }

            Set<Integer> hashSetGameCodes = new HashSet<>(gameWithoutAppointment.getGameCodes());

            if (hashSetGameCodes.size() == gameWithoutAppointment.getGameCodes().size() && validator == true ? true : false) {
                repository.save(gameWithoutAppointment);
            } else {
                throw new RuntimeException("");
            }


        } catch (Exception err) {
            throw new CannotCreateBeachTennisGameException("Cannot create a game: Please, check the game codes list and try again! " +
                    "Game codes inserted:" + gameWithoutAppointment.getGameCodes() + " " + err.getMessage());
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
}
