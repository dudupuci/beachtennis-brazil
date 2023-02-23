package br.com.beachtennisbrazil.api.app.entities.validation;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.BeachTennisGameValidatorInterface;
import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateBeachTennisGameException;


public class BeachTennisGameValidator implements BeachTennisGameValidatorInterface {

    /* Implementar também a validacao dos players, para ver se eles tem registro
     */

    @Override
    public boolean validateIfTheGameCanBeCreated(BeachTennisGame beachTennisGame) {
        if (beachTennisGame.getGameCodes().size() < 2 || beachTennisGame.getContractedHours().getHour() < 1) {
            throw new CannotCreateBeachTennisGameException(
                    "Please, check the fields: Players count: " + beachTennisGame.getGameCodes().size()
                            + " and hours: " + beachTennisGame.getContractedHours());
        }
        return true;
    }
}
