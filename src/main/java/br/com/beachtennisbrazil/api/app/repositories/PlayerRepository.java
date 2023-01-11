package br.com.beachtennisbrazil.api.app.repositories;

import br.com.beachtennisbrazil.api.app.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
