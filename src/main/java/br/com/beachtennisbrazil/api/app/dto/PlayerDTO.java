package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PlayerDTO {

    private UUID id;
    private String name;
    private String telephone;
    private String cpf;
    private String document;
    private SubscriptionPlan plan;
    private LocalDateTime registrationDate;
    public Player toEntity() {
        return Player.builder()
                .id(this.id)
                .plan(this.plan)
                .name(this.name)
                .cpf(this.cpf)
                .telephone(this.telephone)
                .document(this.document)
                .registrationDate(this.registrationDate)
                .build();
    }
}
