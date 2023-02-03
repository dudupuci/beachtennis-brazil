package br.com.beachtennisbrazil.api.system.dto;

import br.com.beachtennisbrazil.api.system.entities.Login;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDTO {

    private String username;
    private String password;

    public Login toLogin() {
        return Login.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}

