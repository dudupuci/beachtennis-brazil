package br.com.beachtennisbrazil.api.app.service;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Player;

import java.util.List;
import java.util.UUID;

public interface GameCourtServiceInterface {
    List<GameCourt> findAll();
    GameCourt findById(UUID id);
    void createGameCourt(GameCourt gameCourt);
    void updateGameCourtData(GameCourt oldGameCourt, GameCourt newGameCourt);
    void updateAndSaveGameCourt(UUID id, GameCourt newGameCourt);
    void deleteGameCourtById(UUID id);
}
