package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotFindAccessCodeException extends RuntimeException {
    public CannotFindAccessCodeException(String err) {
        super(err);
    }
}
