package br.com.beachtennisbrazil.api.app.exceptions;

public class CannotUpdateBeachTennisGameException extends RuntimeException {
    public CannotUpdateBeachTennisGameException(String err) {
        super(err);
    }
}
