package br.com.beachtennisbrazil.api.app.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String err) {
        super(err);
    }
}
