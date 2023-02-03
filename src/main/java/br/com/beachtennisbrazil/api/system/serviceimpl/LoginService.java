package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateGameCourtException;
import br.com.beachtennisbrazil.api.system.dto.LoginDTO;
import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.exceptions.CannotFindLoginInDatabaseException;
import br.com.beachtennisbrazil.api.system.repositories.LoginRepository;
import br.com.beachtennisbrazil.api.system.repositories.RegisterRepository;
import br.com.beachtennisbrazil.api.system.service.LoginInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoginService implements LoginInterface {

    @Autowired
    private LoginRepository repository;


    @Override
    public Login findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new CannotCreateGameCourtException("Cannot find login!"));
    }

    @Override
    public LoginDTO authenticate(Login login) {
        var authentication = repository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        var dto = authentication.toDto();

        if (authentication != null) {
            return dto;
        } else {
            throw new CannotFindLoginInDatabaseException("");
        }
    }

    @Override
    public void deleteLogins() {
        repository.deleteAll();
    }

    @Override
    public List<Login> findAllUsernames() {
        return repository.findAll();
    }
}
