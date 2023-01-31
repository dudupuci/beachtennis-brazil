package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {
}
