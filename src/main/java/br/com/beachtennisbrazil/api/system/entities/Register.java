package br.com.beachtennisbrazil.api.system.entities;

import lombok.*;
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
    private String email;

    public Login createLogin() {
        return Login.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .build();
    }
}

