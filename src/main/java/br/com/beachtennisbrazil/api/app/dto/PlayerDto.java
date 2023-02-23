package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PlayerDto {

    private UUID id;
    private String name;
    private String telephone;
    private String cpf;
    private SubscriptionPlan plan;
    private LocalDateTime registrationDate;
    public Player toEntity() {
        return Player.builder()
                .id(this.id)
                .plan(this.plan)
                .name(this.name)
                .cpf(this.cpf)
                .telephone(this.telephone)
                .registrationDate(this.registrationDate)
                .build();
    }
}
