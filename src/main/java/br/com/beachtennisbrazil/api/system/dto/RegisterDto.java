package br.com.beachtennisbrazil.api.system.dto;

import br.com.beachtennisbrazil.api.system.entities.Register;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterDto {

    private UUID id;
    private String username;
    private String password;
    private String confirmPassword;

    public Register toLogin() {
        return Register.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .confirmPassword(this.confirmPassword)
                .build();
    }
}

