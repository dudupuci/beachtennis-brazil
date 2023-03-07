package br.com.beachtennisbrazil.api.system.exceptions;

public class CannotFindPlayerOrAccessCodeException extends RuntimeException {
    public CannotFindPlayerOrAccessCodeException(String msg) {
        super(msg);
    }
}
