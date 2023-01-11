package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.enums.SubscriptionPlanName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriptionPlan {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Enumerated(EnumType.STRING)
    private SubscriptionPlanName planName;
    private Integer numberOfPersonsThePlanSupports;
    //@Transient
    //private List<Player> players = new ArrayList<>();
    //private LocalDateTime purchaseDate = LocalDateTime.now();
    //private LocalDateTime renewalDate;
    private Double value;
    private boolean isActive;
}
