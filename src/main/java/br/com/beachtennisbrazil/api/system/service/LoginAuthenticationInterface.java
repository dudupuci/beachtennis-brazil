package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.models.Login;

public interface LoginAuthenticationInterface {
    void authenticate(Login login);
}
