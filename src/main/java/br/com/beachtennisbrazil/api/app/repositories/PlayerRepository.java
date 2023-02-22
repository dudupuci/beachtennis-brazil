package br.com.beachtennisbrazil.api.app.repositories;

import br.com.beachtennisbrazil.api.app.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    //@Query(value = "SELECT * FROM player where game_code =:gameCode", nativeQuery = true)

    Player findByGameCode(Integer gameCode);

    Player findByName(String name);

    @Query(value = "select p.name, p.document, p.game_code, p.registration_date, p.telephone FROM player p", nativeQuery = true)
    List<Player> findAllInformationFromPlayers();


    Player findByCpf(String cpf);
}
