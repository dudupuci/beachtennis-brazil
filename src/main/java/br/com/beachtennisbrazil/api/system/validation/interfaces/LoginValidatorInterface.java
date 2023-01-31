package br.com.beachtennisbrazil.api.system.validation.interfaces;

public interface LoginValidatorInterface {
     boolean validateUsername(String username);
     boolean validatePassword(String password);
}
