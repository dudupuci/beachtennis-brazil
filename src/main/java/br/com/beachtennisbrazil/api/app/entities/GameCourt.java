package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.entities.enums.TypeOfGame;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameCourt {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private LocalDateTime gameDate;
    private Integer startTime;
    private Integer endTime;
    private Integer playersOnTheCourt;
    private TypeOfGame typeOfGame;

}
