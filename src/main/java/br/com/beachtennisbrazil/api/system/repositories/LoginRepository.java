package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {
    Login findByUsernameAndPassword(String username, String password);
}
