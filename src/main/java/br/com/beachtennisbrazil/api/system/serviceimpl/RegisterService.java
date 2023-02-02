package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.entities.validation.RegisterValidator;
import br.com.beachtennisbrazil.api.system.exceptions.CannotRegisterNewLoginException;
import br.com.beachtennisbrazil.api.system.exceptions.LoginUsernameOrPasswordIsInvalidException;
import br.com.beachtennisbrazil.api.system.exceptions.UsernameAlreadyExistsException;
import br.com.beachtennisbrazil.api.system.repositories.RegisterRepository;
import br.com.beachtennisbrazil.api.system.service.RegistrationInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService implements RegistrationInterface {

    @Autowired
    private RegisterRepository repository;

    @Override
    public Boolean validateRegistration(Login login) {
        RegisterValidator validator = new RegisterValidator();
        validator.validateFields(login.getUsername(), login.getPassword());

        if (login != null) {
            return true;
        } else {
            throw new LoginUsernameOrPasswordIsInvalidException("Please, verify the fields and try again!");
        }
    }

    @Override
    public Login save(Login login) {
        var verify = repository.findByUsername(login.getUsername());
        if (validateRegistration(login) && verify == null) {
            repository.save(login);
        } else {
            throw new UsernameAlreadyExistsException("Login username: " +(login.getUsername())+" is already on database!");
        }
        return login;
    }
}
