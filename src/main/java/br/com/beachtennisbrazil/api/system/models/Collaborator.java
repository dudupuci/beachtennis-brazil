package br.com.beachtennisbrazil.api.system.models;

import br.com.beachtennisbrazil.api.app.entities.Person;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;
import br.com.beachtennisbrazil.api.system.enums.TypeOfContract;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Collaborator extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private Double salary;
    @Enumerated(EnumType.STRING)
    private CollaboratorPaper function;
    @Enumerated(EnumType.STRING)
    private TypeOfContract contract;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private LocalDateTime resignationDate;
    private boolean isOnVacation;


}
