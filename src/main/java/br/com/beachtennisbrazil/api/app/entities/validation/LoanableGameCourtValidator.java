package br.com.beachtennisbrazil.api.app.entities.validation;

import br.com.beachtennisbrazil.api.app.entities.GameCourt;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.GameCourtValidatorInterface;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.LoanableValidatorInterface;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;

public class LoanableGameCourtValidator implements LoanableValidatorInterface {

    @Override
    public boolean validateIfTheGameCanHaveMoreLoaners(GameCourt gameCourt) {
        if (gameCourt.getTypeOfGame() == TypeOfGame.SIMPLE
                && gameCourt.getLoanables().size() > 3) {
            return false;
        } else if (gameCourt.getTypeOfGame() == TypeOfGame.DOUBLES
                && gameCourt.getLoanables().size() > 5) {
            return false;
        } else if (gameCourt.getTypeOfGame() == TypeOfGame.CLASS
                && gameCourt.getLoanables().size() > 1) {
            return false;
        } else {
            return true;
        }
    }
}
