package br.com.beachtennisbrazil.api.app.entities.validation.interfaces;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;

public interface GameCourtValidatorInterface {
    boolean validateIfTheGameCanBeCreated(GameCourt gameCourt);
}
