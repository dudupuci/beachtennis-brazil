package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.entities.SentEmailPlayer;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SentEmailsPlayerRepository extends JpaRepository<SentEmailPlayer, UUID> {

    List<SentEmailPlayer> findByTypeOfEmail(TypeOfEmailSent type);
    List<SentEmailPlayer> findByTo(String to);
    List<SentEmailPlayer> findByFrom(String from);
}
