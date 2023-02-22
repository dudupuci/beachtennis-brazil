package br.com.beachtennisbrazil.api.app.serviceimpl;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.app.service.PlayerServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerService implements PlayerServiceInterface {

    @Autowired
    private PlayerRepository repository;

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Player> findAllInformationFromPlayers() {
        return repository.findAllInformationFromPlayers();
    }

    @Override
    public Player findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public Player findByGameCode(Integer gameCode) {
        return repository.findByGameCode(gameCode);
    }

    @Override
    public Player findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Player findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public void save(Player player) {
        try {
            repository.save(player);
        } catch (Exception err) {
            throw new RuntimeException("" +err.getMessage());
        }
    }

    @Override
    public void updateData(Player oldPlayer, Player newPlayer) {

    }

    @Override
    public void updateAndSavePlayer(UUID id, Player newPlayer) {

    }

    @Override
    public void deletePlayerById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception err) {
            throw new RuntimeException(""+ err.getMessage());
        }
    }
}
