package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.entities.Register;

import java.util.UUID;

public interface RegistrationInterface {
    Boolean validateRegistration(Register register);
    Register convertRegisterToLogin(Register register);

}
