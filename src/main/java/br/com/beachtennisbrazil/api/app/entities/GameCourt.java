package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.GameCourtDTO;
import br.com.beachtennisbrazil.api.app.entities.converters.SetOfIntegersConverter;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.websocket.OnError;
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
@JsonPropertyOrder({"id", "gameDate", "typeOfGame", "startTime", "endTime", "contractedHours", "quantityPlayingNow"})
public class  GameCourt implements Serializable {
      /* Só pode ser iniciado caso seja um jogo simples de 2 pessoas ou duplas, 4 pessoas.
       Só pode ser iniciado caso a quadra seja alocada por um dos jogadores,
        o jogador cadastrado e a quadra paga.
        Pode também ser iniciada caso seja aula, torneio, etc.

       Cada jogador tem um gameCode

       Implementar consulta de jogadores por game code, registrar partidas jogadas para cada jogador
       associado ao seus devidos gameCodes, implementar o botão de visualizar na tabela
     */

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
    @NotEmpty(message = "Cannot be empty.")
    private LocalTime contractedHours;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    @Transient
    private List<Loanable> loanables = new ArrayList<>();

    private Integer quantityPlayingNow;
    @Enumerated(EnumType.STRING)
    private TypeOfGame typeOfGame;

    @Convert(converter = SetOfIntegersConverter.class)
    @Size(min = 2, max = 4, message = "Check the field!")
    @NotEmpty(message = "Cannot be empty.")
    private List<Integer> gameCodes = new ArrayList<>();

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
