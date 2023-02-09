package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.entities.SentEmail;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SentEmailsRepository extends JpaRepository<SentEmail, UUID> {

    List<SentEmail> findByTypeOfEmail(TypeOfEmailSent type);
    List<SentEmail> findByTo(String to);
    List<SentEmail> findByFrom(String from);
}
