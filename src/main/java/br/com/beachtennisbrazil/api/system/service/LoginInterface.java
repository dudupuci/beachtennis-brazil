package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.dto.LoginDto;
import br.com.beachtennisbrazil.api.system.entities.Login;

import java.util.List;
import java.util.UUID;

public interface LoginInterface {
    Login findById(UUID uuid);
    LoginDto authenticate(Login login);

    Login recoveryPassword(String email);

    void deleteLogins();
    void deleteById(UUID id);

    List<Login> findAllUsernames();
}
