package br.com.beachtennisbrazil.api.app.entities;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class GameCode {
    private Integer gameCode;

}
