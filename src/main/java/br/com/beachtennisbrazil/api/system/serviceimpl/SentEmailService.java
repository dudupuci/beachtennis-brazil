package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.system.entities.SentEmail;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import br.com.beachtennisbrazil.api.system.repositories.SentEmailsRepository;
import br.com.beachtennisbrazil.api.system.service.SentEmailsInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SentEmailService implements SentEmailsInterface {

    @Autowired
    private SentEmailsRepository repository;


    @Override
    public SentEmail findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public List<SentEmail> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SentEmail> findByTypeOfEmail(TypeOfEmailSent type) {
         return repository.findByTypeOfEmail(type);
    }

    @Override
    public List<SentEmail> findByTo(String to) {
        return repository.findByTo(to);
    }

    @Override
    public List<SentEmail> findByFrom(String from) {
        return repository.findByFrom(from);
    }
}
