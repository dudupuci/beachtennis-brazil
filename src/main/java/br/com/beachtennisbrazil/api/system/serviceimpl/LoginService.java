package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.system.models.Login;
import br.com.beachtennisbrazil.api.system.repositories.LoginRepository;
import br.com.beachtennisbrazil.api.system.service.LoginAuthenticationInterface;
import br.com.beachtennisbrazil.api.system.validation.LoginValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService implements LoginAuthenticationInterface {

    @Autowired
    private LoginRepository repository;

    @Override
    public void authenticate(Login login) {
        LoginValidator validator = new LoginValidator();
        validator.validateUsername(login.getUsername());
        validator.validatePassword(login.getPassword());

        if (login.getUsername() != null && login.getPassword() != null) {

        }
    }
}
