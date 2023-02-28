package br.com.beachtennisbrazil.api.app.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("game_by_appointment")
public class GameByAppointment extends BeachTennisGame {

    private LocalDate appointmentDate;



}
