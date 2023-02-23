package br.com.beachtennisbrazil.api.system.service;

import br.com.beachtennisbrazil.api.system.entities.Collaborator;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;

import java.util.List;
import java.util.UUID;

public interface CollaboratorInterface {
    Collaborator findById(UUID id);

    List<Collaborator> findByFunction(CollaboratorPaper function);

    List<Collaborator> findByIsOnVacation(Boolean isOnVacation);

    List<Collaborator> findAll();

    void createCollaborator(Collaborator collaborator);

    void deleteCollaboratorById(UUID id);

    void updateCollaborator(Collaborator oldCollaborator, Collaborator newCollaborator);

    void updateAndSaveCollaborator(UUID id, Collaborator newCollaborator);
}
