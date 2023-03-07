package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.BeachTennisGameDto;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import br.com.beachtennisbrazil.api.app.enums.TypeOfSchedule;
import br.com.beachtennisbrazil.api.system.entities.converters.ListOfIntegersConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "beach_tennis_game")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class BeachTennisGame implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @JsonIgnore
    @Transient
    private Timestamp timeConverter = Timestamp.from(Instant.now());
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime contractedHours;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private LocalDate gameDate = LocalDate.now();
    @Transient
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    @Enumerated(EnumType.STRING)
    private TypeOfGame typeOfGame;

    @Enumerated(EnumType.STRING)
    private TypeOfSchedule typeOfSchedule;

    // implementar os game codes apenas para quem for agendar no sistema.
    @Convert(converter = ListOfIntegersConverter.class)
    private List<Integer> accessCodes = new ArrayList<>();

}
