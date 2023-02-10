package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.entities.SentEmail;
import br.com.beachtennisbrazil.api.system.entities.validation.RegisterValidator;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import br.com.beachtennisbrazil.api.system.exceptions.CannotRegisterNewLoginException;
import br.com.beachtennisbrazil.api.system.exceptions.UsernameAlreadyExistsException;
import br.com.beachtennisbrazil.api.system.javaxmail.JavaxMailTemplateSender;
import br.com.beachtennisbrazil.api.system.javaxmail.templates.RegisterTemplateMapper;
import br.com.beachtennisbrazil.api.system.repositories.RegisterRepository;
import br.com.beachtennisbrazil.api.system.repositories.SentEmailsRepository;
import br.com.beachtennisbrazil.api.system.service.RegistrationInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegisterService implements RegistrationInterface {

    @Autowired
    private RegisterRepository repository;

    @Autowired
    private SentEmailsRepository emailsRepository;

    private final String DEFAULT_SENDER = "dudupucinelli@gmail.com";


    @Override
    public Boolean validateRegistration(Register register) {
        RegisterValidator validator = new RegisterValidator();
        validator.validateFields(
                register.getUsername(),
                register.getPassword(),
                register.getConfirmPassword(),
                register.getEmail());

        if (register != null) {
            return true;
        } else {
            throw new CannotRegisterNewLoginException("Please, verify the fields and try again!");
        }
    }

    @Override
    public Register convertRegisterToLogin(Register register) {
        var verify = repository.findByUsername(register.getUsername());
        if (validateRegistration(register) && verify == null) {
            var login = register.createLogin();
            repository.save(login);

            RegisterTemplateMapper template = new RegisterTemplateMapper();
            SentEmail addressing = new SentEmail();

            JavaxMailTemplateSender.configuration(
                    register.getEmail(),
                    DEFAULT_SENDER,
                    template.getSubject(),
                    template.getTextMessage(register.getUsername(), register.getPassword()));

            addressing.setFrom(DEFAULT_SENDER);
            addressing.setTo(register.getEmail());
            addressing.setSubject(template.getSubject());
            addressing.setMessage(template.getTextMessage(register.getUsername(), register.getPassword()));
            addressing.setSendedMoment(LocalDateTime.now());
            addressing.setTypeOfEmail(TypeOfEmailSent.REGISTRATION);
            addressing.setLogin(login);
            emailsRepository.save(addressing);

            return register;
        } else {
            throw new UsernameAlreadyExistsException("Login username is already on database!");
        }
    }
}
