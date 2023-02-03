package br.com.beachtennisbrazil.api.system.exceptions;

public class ConfirmationPasswordDoesNotMatchThePassword extends RuntimeException {
    public ConfirmationPasswordDoesNotMatchThePassword(String msg) {
        super(msg);
    }
}
