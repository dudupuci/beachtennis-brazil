package br.com.beachtennisbrazil.api.system.repositories;

import br.com.beachtennisbrazil.api.system.entities.Collaborator;
import br.com.beachtennisbrazil.api.system.entities.Login;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.List;
import java.util.UUID;

public interface CollaboratorRepository extends JpaRepository<Collaborator, UUID> {
    Streamable<Collaborator> findByFunction(CollaboratorPaper value);
    Streamable<Collaborator> findByIsOnVacation(boolean response);
    List<Collaborator> findByContract(String contract);
}
