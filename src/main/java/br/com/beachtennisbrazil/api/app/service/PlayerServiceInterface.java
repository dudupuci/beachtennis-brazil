package br.com.beachtennisbrazil.api.app.service;

import br.com.beachtennisbrazil.api.app.entities.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerServiceInterface {
    List<Player> findAll();
    Player findById(UUID id);
    void save(Player player);
    void updateData(Player oldPlayer, Player newPlayer);
    void updateAndSavePlayer(UUID id, Player newPlayer);
    void deletePlayerById(UUID id);
}
