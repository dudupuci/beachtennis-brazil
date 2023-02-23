package br.com.beachtennisbrazil.api.app.entities.validation;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;
import br.com.beachtennisbrazil.api.app.entities.validation.interfaces.LoanableValidatorInterface;
import br.com.beachtennisbrazil.api.app.enums.TypeOfGame;

public class LoanableBeachTennisGameValidator implements LoanableValidatorInterface {

    @Override
    public boolean validateIfTheGameCanHaveMoreLoaners(BeachTennisGame beachTennisGame) {
        if (beachTennisGame.getTypeOfGame() == TypeOfGame.SIMPLE
                && beachTennisGame.getLoanables().size() > 3) {
            return false;
        } else if (beachTennisGame.getTypeOfGame() == TypeOfGame.DOUBLES
                && beachTennisGame.getLoanables().size() > 5) {
            return false;
        } else if (beachTennisGame.getTypeOfGame() == TypeOfGame.CLASS
                && beachTennisGame.getLoanables().size() > 1) {
            return false;
        } else {
            return true;
        }
    }
}
