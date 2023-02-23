package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.Loanable;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeachTennisGameDto {
    private UUID id;
    private LocalDate gameDate = LocalDate.now();

    private Timestamp timeConverter = Timestamp.from(Instant.now());
    private LocalTime startTime;
    private LocalTime contractedHours;
    private LocalTime endTime;
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    private TypeOfGame typeOfGame;
    private List<Integer> gameCodes = new ArrayList<>();

    public BeachTennisGame toEntity() {
        return BeachTennisGame.builder()
                .id(this.id)
                .gameDate(this.gameDate)
                .timeConverter(this.timeConverter)
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
