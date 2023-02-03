package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.Loanable;
import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCourtDTO {
    private UUID id;
    private LocalDateTime gameDate = LocalDateTime.now();
    private Integer startTime;
    private Integer contractedHours;
    private Integer endTime;
    private List<Loanable> loanables = new ArrayList<>();
    private Integer quantityPlayingNow;
    private TypeOfGame typeOfGame;
    private List<Player> players = new ArrayList<>();

    public GameCourt toEntity() {
        return GameCourt.builder()
                .id(this.id)
                .gameDate(this.gameDate)
                .startTime(this.startTime)
                .contractedHours(this.contractedHours)
                .endTime(this.endTime)
                .loanables(this.loanables)
                .quantityPlayingNow(this.quantityPlayingNow)
                .typeOfGame(this.typeOfGame)
                .players(this.players)
                .build();
    }
}
