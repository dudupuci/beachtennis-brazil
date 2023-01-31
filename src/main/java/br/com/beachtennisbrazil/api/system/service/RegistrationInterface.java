package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.Login;

import java.util.UUID;

public interface RegistrationInterface {
    Boolean validateRegistration(Login login);
    Login save(Login login);

}
