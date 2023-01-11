package br.com.beachtennisbrazil.api.system.validation;

public interface LoginValidatorInterface {
     boolean validateLogin(String username);
     boolean validatePassword(String password);
}
