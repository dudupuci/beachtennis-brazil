package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotCreateGameCourtException extends RuntimeException {
    public CannotCreateGameCourtException(String err) {
        super(err);
    }
}
