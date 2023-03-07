package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SentEmailsAdminRepository extends JpaRepository<SentEmailAdmin, UUID> {

    List<SentEmailAdmin> findByTypeOfEmail(TypeOfEmailSent type);
    List<SentEmailAdmin> findByTo(String to);
    List<SentEmailAdmin> findByFrom(String from);
}
