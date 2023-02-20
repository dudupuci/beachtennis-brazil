package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.GameCode;
import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Loanable;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCourtDTO {
    private UUID id;
    private LocalDate gameDate = LocalDate.now();

    private Timestamp timeConverter = Timestamp.from(Instant.now());
    private LocalTime startTime;
    private LocalTime contractedHours;
    private LocalTime endTime;
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    private TypeOfGame typeOfGame;
    private Set<String> gameCodes = new HashSet<>();

    public GameCourt toEntity() {
        return GameCourt.builder()
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
