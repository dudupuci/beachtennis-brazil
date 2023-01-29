package br.com.beachtennisbrazil.api.app.entities.validation;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.GameCourtValidatorInterface;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateGameCourtException;

public class GameCourtValidator implements GameCourtValidatorInterface {
    @Override
    public boolean validateIfTheGameCanBeCreated(GameCourt gameCourt) {
            if (gameCourt.getPlayers().size() < 2 || gameCourt.getContractedHours() < 1) {
                return false;
            } else {
                return true;
            }
    }
}
