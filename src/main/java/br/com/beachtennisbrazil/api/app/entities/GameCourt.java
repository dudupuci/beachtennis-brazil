package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"id", "gameDate", "typeOfGame", "startTime", "endTime", "contractedHours", "quantityPlayingNow" })
public class GameCourt {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime gameDate = LocalDateTime.now();
    @JsonFormat(pattern = "HH:mm:ss")
    private Integer startTime;
    private Integer contractedHours;
    @JsonFormat(pattern = "HH:mm:ss")
    private Integer endTime;
    @Transient
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    @Enumerated(EnumType.STRING)
    private TypeOfGame typeOfGame;

    @Transient
    private List<Player> players = new ArrayList<>();

    /* Só pode ser iniciado caso seja um jogo simples de 2 pessoas ou duplas, 4 pessoas.
       Só pode ser iniciado caso a quadra seja alocada por um dos jogadores,
        o jogador cadastrado e a quadra paga.
       Pode também ser iniciada caso seja aula, torneio, etc.
     */

}
