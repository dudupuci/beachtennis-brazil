package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.Register;

public interface RegistrationInterface {
    Boolean validateRegistration(Register register);
    Register convertRegisterToLogin(Register register);

}
