package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.enums.SubscriptionPlanName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private Double value;
    private boolean isActive;
}
