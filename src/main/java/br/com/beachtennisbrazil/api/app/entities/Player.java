package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.entities.enums.TypeOfGame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "quota_id")
    private Quota quota;

    private LocalDateTime dateOfRegistrationOfHours = LocalDateTime.now();
    private Integer entryTime;
    private Integer contractedHours;
    private Integer exitTime;
}
