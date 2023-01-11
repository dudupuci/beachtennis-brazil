package br.com.beachtennisbrazil.api.app.dto;

import br.com.beachtennisbrazil.api.app.entities.Player;
import br.com.beachtennisbrazil.api.app.entities.SubscriptionPlan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PlayerDTO {

    private UUID id;
    @JsonProperty("name")
    private String name;
    private String telephone;
    private String document;
    private SubscriptionPlan plan;

   public void toEntity(Player player) {
       this.id = player.getId();
       this.name = player.getName();
       this.telephone = player.getTelephone();
       this.plan = player.getPlan();
   }



}
