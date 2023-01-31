package br.com.beachtennisbrazil.api.system.exceptions;

public class CannotRegisterNewLoginException extends RuntimeException {
    public CannotRegisterNewLoginException(String msg) {
        super(msg);
    }
}
