package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.GameCourtDTO;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonPropertyOrder({"id", "gameDate", "typeOfGame", "startTime", "endTime", "contractedHours", "quantityPlayingNow" })
public class GameCourt {

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
    private LocalTime contractedHours;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    @Transient
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    @Enumerated(EnumType.STRING)
    private TypeOfGame typeOfGame;

    @Transient
    private Map<Integer, String> gameCodes = new HashMap<>();

    /* Só pode ser iniciado caso seja um jogo simples de 2 pessoas ou duplas, 4 pessoas.
       Só pode ser iniciado caso a quadra seja alocada por um dos jogadores,
        o jogador cadastrado e a quadra paga.
       Pode também ser iniciada caso seja aula, torneio, etc.
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
