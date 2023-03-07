package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.PlayerDto;
import br.com.beachtennisbrazil.api.app.dto.PlayerSystemAccessDto;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.AccessCodeGeneratorInterface;
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
@ToString
@Builder
@JsonPropertyOrder({"id", "name", "document", "telephone", "plan", "registrationDate"})
public class Player {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    @Column(name = "access_code", unique = true)
    private Integer accessCode = AccessCodeGeneratorInterface.getUniqueRandomAccessCode();
    @Column(name = "name")
    private String name;

    @Column(name = "document", unique = true)
    private String cpf;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime registrationDate = LocalDateTime.now();

    public PlayerDto toDto() {
        return PlayerDto.builder()
                .id(this.id)
                .cpf(this.cpf)
                .plan(this.plan)
                .registrationDate(this.registrationDate)
                .build();
    }

    public PlayerSystemAccessDto toPlayerSystemAccessDto() {
        return PlayerSystemAccessDto.builder()
                .id(this.id)
                .cpf(this.cpf)
                .accessCode(this.accessCode)
                .build();

    }

}
