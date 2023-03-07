package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import br.com.beachtennisbrazil.api.system.repositories.SentEmailsAdminRepository;
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
    private SentEmailsAdminRepository repository;


    @Override
    public SentEmailAdmin findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public List<SentEmailAdmin> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SentEmailAdmin> findByTypeOfEmail(TypeOfEmailSent type) {
         return repository.findByTypeOfEmail(type);
    }

    @Override
    public List<SentEmailAdmin> findByTo(String to) {
        return repository.findByTo(to);
    }

    @Override
    public List<SentEmailAdmin> findByFrom(String from) {
        return repository.findByFrom(from);
    }
}
