package br.com.beachtennisbrazil.api.system.serviceimpl;

import br.com.beachtennisbrazil.api.app.exceptions.EntityNotFoundException;
import br.com.beachtennisbrazil.api.system.entities.Collaborator;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;
import br.com.beachtennisbrazil.api.system.repositories.CollaboratorRepository;
import br.com.beachtennisbrazil.api.system.service.CollaboratorInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CollaboratorService implements CollaboratorInterface {

    @Autowired
    private CollaboratorRepository repository;

    @Override
    public Collaborator findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    @Override
    public List<Collaborator> findByFunction(CollaboratorPaper value) {
        try {
            return repository.findByFunction(CollaboratorPaper.valueOf(value.toString())).toList();
        } catch (Exception err) {
            throw new RuntimeException("");
        }
    }

    @Override
    public List<Collaborator> findByIsOnVacation(Boolean isOnVacation) {
        try {
            return repository.findByIsOnVacation(isOnVacation).toList();
        } catch (Exception err) {
            throw new RuntimeException("");
        }
    }


    @Override
    public List<Collaborator> findAll() {
        return null;
    }

    @Override
    public void createCollaborator(Collaborator collaborator) {

    }

    @Override
    public void deleteCollaboratorById(UUID id) {

    }

    @Override
    public void updateCollaborator(Collaborator oldCollaborator, Collaborator newCollaborator) {

    }

    @Override
    public void updateAndSaveCollaborator(UUID id, Collaborator newCollaborator) {

    }
}
