package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotUpdateGameCourtException extends RuntimeException {
    public CannotUpdateGameCourtException(String err) {
        super(err);
    }
}
