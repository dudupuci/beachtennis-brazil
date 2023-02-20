package br.com.beachtennisbrazil.api.app.entities.validation;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.GameCourtValidatorInterface;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateGameCourtException;

public class GameCourtValidator implements GameCourtValidatorInterface {

    /* Implementar também a validacao dos players, para ver se eles tem registro

     */
    @Override
    public boolean validateIfTheGameCanBeCreated(GameCourt gameCourt) {
        if (gameCourt.getGameCodes().size() < 2 || gameCourt.getContractedHours().getHour() < 1) {
            throw new CannotCreateGameCourtException(
                    "Please, check the fields: Players count: " + gameCourt.getGameCodes().size()
                            + " and hours: " + gameCourt.getContractedHours());
        } else {
            return true;
        }

    }
}
