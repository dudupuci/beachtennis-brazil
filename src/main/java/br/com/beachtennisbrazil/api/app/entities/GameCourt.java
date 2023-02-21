package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.GameCourtDTO;
import br.com.beachtennisbrazil.api.app.entities.converters.SetOfIntegersConverter;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonPropertyOrder({"id", "gameDate", "typeOfGame", "startTime", "endTime", "contractedHours", "quantityPlayingNow"})
public class GameCourt implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate gameDate = LocalDate.now();
    @JsonIgnore
    @Transient
    private Timestamp timeConverter = Timestamp.from(Instant.now());
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime contractedHours;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    @Transient
    private List<Loanable> loanables = new ArrayList<>();

    private Integer quantityPlayingNow;
    @Enumerated(EnumType.STRING)
    private TypeOfGame typeOfGame;

    @Convert(converter = SetOfIntegersConverter.class)
    private Set<Integer> gameCodes = new HashSet<>();

    /* Só pode ser iniciado caso seja um jogo simples de 2 pessoas ou duplas, 4 pessoas.
       Só pode ser iniciado caso a quadra seja alocada por um dos jogadores,
        o jogador cadastrado e a quadra paga.
        Pode também ser iniciada caso seja aula, torneio, etc.

       Cada jogador tem um gameCode
     */

    public GameCourtDTO toDto() {
        return GameCourtDTO.builder()
                .id(this.id)
                .timeConverter(this.timeConverter)
                .gameDate(this.gameDate)
                .startTime(this.startTime)
                .contractedHours(this.contractedHours)
                .endTime(this.endTime)
                .loanables(this.loanables)
                .quantityPlayingNow(this.quantityPlayingNow)
                .typeOfGame(this.typeOfGame)
                .gameCodes(this.gameCodes)
                .build();
    }
}
