package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.entities.validation.GameCourtValidator;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateGameCourtException;
import br.com.beachtennisbrazil.api.app.exceptions.CannotUpdateGameCourtException;
import br.com.beachtennisbrazil.api.app.exceptions.EntityNotFoundException;
import br.com.beachtennisbrazil.api.app.repositories.GameCourtRepository;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.app.service.GameCourtServiceInterface;
import br.com.beachtennisbrazil.api.app.service.PlayerServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameCourtService implements GameCourtServiceInterface {

    @Autowired
    private GameCourtRepository repository;

    @Override
    public List<GameCourt> findAll() {
        return repository.findAll();
    }

    @Override
    public GameCourt findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found exception."));
    }

    @Override
    public void createGameCourt(GameCourt gameCourt) {
        try {
            GameCourtValidator gameValidator = new GameCourtValidator();
            var validator = gameValidator.validateIfTheGameCanBeCreated(gameCourt);
            gameCourt.setStartTime(LocalTime.of(gameCourt.getTimeConverter().getHours(), gameCourt.getTimeConverter().getMinutes()));
            gameCourt.setEndTime(gameCourt.getStartTime().plusHours(gameCourt.getContractedHours().getHour()).plusMinutes(gameCourt.getContractedHours().getMinute()));

            if (validator == true) {
                repository.save(gameCourt);
            }

        } catch (Exception err) {
            throw new CannotCreateGameCourtException("Cannot create a game: " + err.getMessage());
        }

    }

    @Override
    public void updateGameCourtData(GameCourt oldGameCourt, GameCourt newGameCourt) {
        oldGameCourt.setGameDate(newGameCourt.getGameDate());
        oldGameCourt.setTypeOfGame(newGameCourt.getTypeOfGame());
        oldGameCourt.setPlayers(newGameCourt.getPlayers());
        oldGameCourt.setStartTime(newGameCourt.getStartTime());
        oldGameCourt.setContractedHours(newGameCourt.getContractedHours());
        oldGameCourt.setQuantityPlayingNow(newGameCourt.getQuantityPlayingNow());
        oldGameCourt.setEndTime(newGameCourt.getEndTime());
        oldGameCourt.setId(newGameCourt.getId());
        oldGameCourt.setLoanables(newGameCourt.getLoanables());
    }

    @Override
    public void updateAndSaveGameCourt(UUID id, GameCourt newGameCourt) {
        try {
            GameCourt oldGameCourt = repository.findById(id).get();
            updateGameCourtData(oldGameCourt, newGameCourt);
            updateAndSaveGameCourt(oldGameCourt.getId(), newGameCourt);
            repository.save(newGameCourt);
        } catch (Exception err) {
            throw new CannotUpdateGameCourtException("Captured error: " + err.getMessage());
        }

    }

    @Override
    public void deleteGameCourtById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception err) {
            throw new EntityNotFoundException("Captured error: Game Court ID: " + id + " has not found! " + err.getMessage());
        }

    }
}
