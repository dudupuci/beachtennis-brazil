package br.com.beachtennisbrazil.api.system.entities;

import br.com.beachtennisbrazil.api.system.dto.LoginDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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


    public LoginDTO toDto() {
        return LoginDTO.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .build();
    }

}

