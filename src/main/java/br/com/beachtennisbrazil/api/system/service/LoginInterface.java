package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.Login;

import java.util.List;
import java.util.UUID;

public interface LoginInterface {
    Login findById(UUID uuid);
    Login authenticate(Login login);

    void deleteLogins();

    List<Login> findAllUsernames();
}
