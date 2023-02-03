package br.com.beachtennisbrazil.api.system.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}
