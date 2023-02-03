package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.dto.LoginDTO;
import br.com.beachtennisbrazil.api.system.entities.Login;

import java.util.List;
import java.util.UUID;

public interface LoginInterface {
    Login findById(UUID uuid);
    LoginDTO authenticate(Login login);

    void deleteLogins();

    List<Login> findAllUsernames();
}
