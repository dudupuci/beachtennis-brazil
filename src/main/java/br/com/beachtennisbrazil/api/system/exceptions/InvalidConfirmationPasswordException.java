package br.com.beachtennisbrazil.api.system.exceptions;

public class InvalidConfirmationPasswordException extends RuntimeException {
    public InvalidConfirmationPasswordException(String msg) {
        super(msg);
    }
}
