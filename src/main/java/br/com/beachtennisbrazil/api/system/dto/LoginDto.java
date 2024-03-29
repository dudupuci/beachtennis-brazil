package br.com.beachtennisbrazil.api.system.dto;

import br.com.beachtennisbrazil.api.system.entities.Login;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDto {

    @JsonIgnore
    private UUID id;
    private String username;
    private String password;
    @JsonIgnore
    private String email;

    public Login toLogin() {
        return Login.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .build();
    }
}

