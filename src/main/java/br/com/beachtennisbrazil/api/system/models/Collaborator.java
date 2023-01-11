package br.com.beachtennisbrazil.api.system.models;

import br.com.beachtennisbrazil.api.app.entities.Person;
import br.com.beachtennisbrazil.api.system.enums.CollaboratorPaper;
import br.com.beachtennisbrazil.api.system.enums.TypeOfContract;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime registrationDate = LocalDateTime.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime resignationDate;
    private boolean isOnVacation;


}
