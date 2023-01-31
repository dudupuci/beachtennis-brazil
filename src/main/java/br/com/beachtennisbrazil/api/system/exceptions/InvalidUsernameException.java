package br.com.beachtennisbrazil.api.system.exceptions;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String msg) {
        super(msg);
    }
}
