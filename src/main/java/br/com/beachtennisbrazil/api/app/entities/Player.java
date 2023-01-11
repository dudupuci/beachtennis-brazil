package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.PlayerDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    private LocalDateTime registrationDate = LocalDateTime.now();
    //private Integer entryTime;
    //private Integer contractedHours;
    //private Integer exitTime;


}
