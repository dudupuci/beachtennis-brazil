package br.com.beachtennisbrazil.api.system.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@DiscriminatorValue("sent_email_admin")
public class SentEmailAdmin extends SentEmail implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Login login;
}
