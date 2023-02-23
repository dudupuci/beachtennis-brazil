package br.com.beachtennisbrazil.api.app.service;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;

import java.util.List;
import java.util.UUID;

public interface BeachTennisGameServiceInterface {
    List<BeachTennisGame> findAll();
    BeachTennisGame findById(UUID id);
    void createBeachTennisGame(BeachTennisGame beachTennisGame);
    void updateBeachTennisGameData(BeachTennisGame oldBeachTennisGame, BeachTennisGame newBeachTennisGame);
    void updateAndSaveBeachTennisGame(UUID id, BeachTennisGame newBeachTennisGame);
    void deleteBeachTennisGameById(UUID id);
}
