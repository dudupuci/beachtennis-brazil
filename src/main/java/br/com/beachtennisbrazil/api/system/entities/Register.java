package br.com.beachtennisbrazil.api.system.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Register {

    private UUID id;
    private String username;
    private String password;
    private String confirmPassword;

    public Login createLogin() {
        return Login.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .build();
    }
}

