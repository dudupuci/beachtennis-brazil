package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.SentEmailAdmin;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;

import java.util.List;
import java.util.UUID;

public interface SentEmailsInterface {
    SentEmailAdmin findById(UUID id);
    List<SentEmailAdmin> findAll();
    List<SentEmailAdmin> findByTypeOfEmail(TypeOfEmailSent type);
    List<SentEmailAdmin> findByTo(String to);
    List<SentEmailAdmin> findByFrom(String from);
}
