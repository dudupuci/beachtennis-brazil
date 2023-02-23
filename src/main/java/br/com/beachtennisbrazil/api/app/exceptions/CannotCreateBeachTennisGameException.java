package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotCreateBeachTennisGameException extends RuntimeException {
    public CannotCreateBeachTennisGameException(String err) {
        super(err);
    }
}
