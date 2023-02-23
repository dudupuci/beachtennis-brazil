package br.com.beachtennisbrazil.api.app.entities;

import br.com.beachtennisbrazil.api.app.dto.BeachTennisGameDto;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;
import br.com.beachtennisbrazil.api.system.entities.converters.ListOfIntegersConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@DiscriminatorValue("game_without_appointment")
public class GameWithoutAppointment extends BeachTennisGame {

    private String motive;

}
