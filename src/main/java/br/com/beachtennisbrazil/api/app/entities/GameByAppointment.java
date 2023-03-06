package br.com.beachtennisbrazil.api.app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue("game_by_appointment")
@Getter
@Setter
public class GameByAppointment extends BeachTennisGame {

    @Column(name = "appointment_date")
    @FutureOrPresent(message = "Appointment date must be a future or present (today) date.")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate appointmentDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

}
