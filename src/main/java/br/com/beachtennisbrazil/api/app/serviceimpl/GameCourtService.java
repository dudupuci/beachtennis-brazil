package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.repositories.GameCourtRepository;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.app.service.GameCourtServiceInterface;
import br.com.beachtennisbrazil.api.app.service.PlayerServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public void createGameCourt(GameCourt gameCourt) {
        try {
            gameCourt.setStartTime(gameCourt.getGameDate().getHour());
            gameCourt.setEndTime(gameCourt.getStartTime() + gameCourt.getContractedHours());
            repository.save(gameCourt);
        } catch (Exception err) {
            throw new RuntimeException("" +err.getMessage());
        }
    }

    @Override
    public void updateGameCourtData(GameCourt oldGameCourt, GameCourt newGameCourt) {

    }

    @Override
    public void updateAndSaveGameCourt(UUID id, GameCourt newGameCourt) {

    }

    @Override
    public void deleteGameCourtById(UUID id) {

    }
}
