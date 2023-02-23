package br.com.beachtennisbrazil.api.app.repositories;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeachTennisGameRepository extends JpaRepository<BeachTennisGame, UUID> {
}
