package br.com.beachtennisbrazil.api.system.entities;

import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SentEmail {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "who_received")
    private String to;

    @Column(name = "who_sent")
    private String from;

    @Column(name = "sended_moment")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime sendedMoment = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_email")
    private TypeOfEmailSent typeOfEmail;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String message;
}