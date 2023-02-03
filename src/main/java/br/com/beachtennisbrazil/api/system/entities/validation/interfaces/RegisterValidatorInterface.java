package br.com.beachtennisbrazil.api.system.entities.validation.interfaces;

public interface RegisterValidatorInterface {
     boolean validateFields(String username, String password, String confirmPassword);
}
