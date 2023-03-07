package br.com.beachtennisbrazil.api.app.repositories;

import br.com.beachtennisbrazil.api.app.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    //@Query(value = "SELECT * FROM player where access_code =:accessCode", nativeQuery = true)

    Player findByAccessCode(Integer accessCode);

    Player findByCpfAndAccessCode(String cpf, Integer accessCode);

    Player findByName(String name);



    Player findByCpf(String cpf);
}
