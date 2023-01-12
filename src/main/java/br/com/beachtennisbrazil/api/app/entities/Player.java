package br.com.beachtennisbrazil.api.app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"id", "name", "document", "telephone", "plan", "registrationDate" })
public class Player extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime registrationDate = LocalDateTime.now();

}
