package br.com.beachtennisbrazil.api.app.entities.validation.interfaces;

import br.com.beachtennisbrazil.api.app.entities.BeachTennisGame;

public interface LoanableValidatorInterface {
    boolean validateIfTheGameCanHaveMoreLoaners(BeachTennisGame beachTennisGame);
}
