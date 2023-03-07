package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSystemAccessDto {

    private UUID id;
    private String cpf;
    private Integer gameCode;
    public Player toEntity() {
        return Player.builder()
                .id(this.id)
                .cpf(this.cpf)
                .gameCode(this.gameCode)
                .build();
    }
}
