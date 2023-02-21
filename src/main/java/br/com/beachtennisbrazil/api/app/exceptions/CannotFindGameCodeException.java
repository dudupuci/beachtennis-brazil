package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotFindGameCodeException extends RuntimeException {
    public CannotFindGameCodeException(String err) {
        super(err);
    }
}
