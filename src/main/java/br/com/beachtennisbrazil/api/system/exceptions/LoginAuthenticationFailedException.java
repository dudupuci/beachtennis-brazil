package br.com.beachtennisbrazil.api.system.exceptions;

public class LoginAuthenticationFailedException extends RuntimeException {
    public LoginAuthenticationFailedException(String msg) {
        super(msg);
    }
}
