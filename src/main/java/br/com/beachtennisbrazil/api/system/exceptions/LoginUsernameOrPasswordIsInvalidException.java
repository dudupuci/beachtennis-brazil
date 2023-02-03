package br.com.beachtennisbrazil.api.system.exceptions;

public class LoginUsernameOrPasswordIsInvalidException extends RuntimeException {
    public LoginUsernameOrPasswordIsInvalidException(String msg) {
        super(msg);
    }
}
