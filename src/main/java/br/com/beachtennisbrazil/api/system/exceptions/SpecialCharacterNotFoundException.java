package br.com.beachtennisbrazil.api.system.exceptions;

public class SpecialCharacterNotFoundException extends RuntimeException {
    public SpecialCharacterNotFoundException(String msg) {
        super(msg);
    }
}
