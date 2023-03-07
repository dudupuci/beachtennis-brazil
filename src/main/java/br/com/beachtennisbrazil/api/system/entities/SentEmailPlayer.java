package br.com.beachtennisbrazil.api.system.entities;

import br.com.beachtennisbrazil.api.app.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("sent_email_player")
public class SentEmailPlayer extends SentEmail implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Player player;

}
