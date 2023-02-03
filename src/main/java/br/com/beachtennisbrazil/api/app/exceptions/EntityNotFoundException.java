package br.com.beachtennisbrazil.api.app.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String err) {
        super(err);
    }
}