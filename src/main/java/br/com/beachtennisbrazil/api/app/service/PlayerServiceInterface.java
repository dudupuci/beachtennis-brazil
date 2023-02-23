package br.com.beachtennisbrazil.api.app.service;

import br.com.beachtennisbrazil.api.app.entities.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerServiceInterface {

    List<Player> findAll();
    List<Player> findAllInformationFromPlayers();
    Player findById(UUID id);
    Player findByGameCode(Integer gameCode);
    Player findByName(String name);
    Player findByCpf(String cpf);
    void save(Player player);
    void updateData(Player oldPlayer, Player newPlayer);
    void updateAndSavePlayer(UUID id, Player newPlayer);
    void deletePlayerById(UUID id);
}
