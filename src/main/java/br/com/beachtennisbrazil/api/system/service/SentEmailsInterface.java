package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.SentEmail;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;

import java.util.List;
import java.util.UUID;

public interface SentEmailsInterface {
    SentEmail findById(UUID id);
    List<SentEmail> findAll();
    List<SentEmail> findByTypeOfEmail(TypeOfEmailSent type);
    List<SentEmail> findByTo(String to);
    List<SentEmail> findByFrom(String from);
}
