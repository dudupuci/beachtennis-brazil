package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotFindSubscriptionPlanException extends RuntimeException{
    public CannotFindSubscriptionPlanException(String err) {
        super(err);
    }
}
