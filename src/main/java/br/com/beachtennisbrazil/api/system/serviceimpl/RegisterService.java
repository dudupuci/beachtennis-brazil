package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.repositories.PlayerRepository;
import br.com.beachtennisbrazil.api.system.entities.Register;
import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.entities.SentEmailPlayer;
import br.com.beachtennisbrazil.api.system.entities.validation.RegisterValidator;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import br.com.beachtennisbrazil.api.system.exceptions.CannotRegisterNewLoginException;
import br.com.beachtennisbrazil.api.system.exceptions.CpfAlreadyExistsOnDatabaseException;
import br.com.beachtennisbrazil.api.system.exceptions.UsernameAlreadyExistsException;
import br.com.beachtennisbrazil.api.system.javaxmail.JavaxMailTemplateSender;
import br.com.beachtennisbrazil.api.system.javaxmail.templates.RegisterTemplateMapper;
import br.com.beachtennisbrazil.api.system.repositories.RegisterRepository;
import br.com.beachtennisbrazil.api.system.repositories.SentEmailsAdminRepository;
import br.com.beachtennisbrazil.api.system.repositories.SentEmailsPlayerRepository;
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
    private PlayerRepository playerRepository;

    @Autowired
    private SentEmailsAdminRepository emailsRepository;

    @Autowired
    private SentEmailsPlayerRepository emailsPlayerRepository;

    private final String DEFAULT_SENDER = "dudupucinelli@gmail.com";


    @Override
    public Boolean validateAdminRegistration(Register register) {
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
    public Boolean validatePlayerRegistration(PlayerSystemAccessDto dto) {
        return false;
    }

    @Override
    public Register convertRegisterToLogin(Register register) {
        var verify = repository.findByUsername(register.getUsername());
        if (validateAdminRegistration(register) && verify == null) {
            var login = register.createLogin();
            repository.save(login);

            RegisterTemplateMapper template = new RegisterTemplateMapper();
            SentEmailAdmin addressing = new SentEmailAdmin();
            var subject = TypeOfEmailSent.ADMIN_REGISTRATION;

            JavaxMailTemplateSender.configuration(
                    register.getEmail(),
                    DEFAULT_SENDER,
                    template.getRegisterSubject(subject),
                    template.getRegisterTextMessage(register.getUsername(), register.getPassword(), subject));

            addressing.setFrom(DEFAULT_SENDER);
            addressing.setTo(register.getEmail());
            addressing.setSubject(template.getRegisterSubject(subject));
            addressing.setMessage(template.getRegisterTextMessage(register.getUsername(), register.getPassword(), subject));
            addressing.setSendedMoment(LocalDateTime.now());
            addressing.setTypeOfEmail(TypeOfEmailSent.ADMIN_REGISTRATION);
            addressing.setLogin(login);
            emailsRepository.save(addressing);

            return register;
        } else {
            throw new UsernameAlreadyExistsException("Login username is already on database!");
        }
    }

    @Override
    public PlayerSystemAccessDto convertPlayerSystemRegisterToPlayerLogin(Player player) {
        var verify = playerRepository.findByCpf(player.getCpf());
        if (verify == null) {
            playerRepository.save(player);

            RegisterTemplateMapper template = new RegisterTemplateMapper();
            SentEmailPlayer addressing = new SentEmailPlayer();
            var subject = TypeOfEmailSent.PLAYER_REGISTRATION;
            JavaxMailTemplateSender.configuration(
                    player.getEmail(),
                    DEFAULT_SENDER,
                    template.getRegisterSubject(subject),
                    template.getRegisterTextMessage(player.getCpf(), player.getAccessCode().toString(), subject));

            addressing.setFrom(DEFAULT_SENDER);
            addressing.setTo(player.getEmail());
            addressing.setSubject(template.getRegisterSubject(subject));
            addressing.setMessage(template.getRegisterTextMessage(player.getCpf(), player.getAccessCode().toString(), subject));
            addressing.setSendedMoment(LocalDateTime.now());
            addressing.setTypeOfEmail(TypeOfEmailSent.PLAYER_REGISTRATION);
            addressing.setPlayer(player);
            emailsPlayerRepository.save(addressing);

            return player.toPlayerSystemAccessDto();
        } else {
            throw new CpfAlreadyExistsOnDatabaseException("CPF already exists on database.");
        }


    }
}
