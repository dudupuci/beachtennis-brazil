package br.com.beachtennisbrazil.api.system.dto;

import br.com.beachtennisbrazil.api.system.entities.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecoveryPasswordDto {
    private String email;
    public Login toRecovery() {
        return Login.builder()
                .email(this.email)
                .build();
    }
}

