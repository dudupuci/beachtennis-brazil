package br.com.beachtennisbrazil.api.system.entities;

import br.com.beachtennisbrazil.api.system.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "login", unique = true)
    private String username;
    private String password;
    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "login", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SentEmail> emails;

    public LoginDTO toDto() {
        return LoginDTO.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .build();
    }
}

