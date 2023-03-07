package br.com.beachtennisbrazil.api.system.exceptions;

public class CannotFindPlayerOrGameCodeException extends RuntimeException {
    public CannotFindPlayerOrGameCodeException(String msg) {
        super(msg);
    }
}
