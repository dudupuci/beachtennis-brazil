package br.com.beachtennisbrazil.api.system.entities.validation;

import br.com.beachtennisbrazil.api.system.entities.validation.interfaces.RegisterValidatorInterface;
import br.com.beachtennisbrazil.api.system.exceptions.InvalidPasswordException;
import br.com.beachtennisbrazil.api.system.exceptions.InvalidUsernameException;
import br.com.beachtennisbrazil.api.system.exceptions.LoginUsernameOrPasswordIsInvalidException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class RegisterValidator implements RegisterValidatorInterface {

    @Override
    public boolean validateFields(String username, String password) {
        Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = specialCharacters.matcher(password);

        if (username == null || username.isBlank() || username.trim().isEmpty()) {
            throw new LoginUsernameOrPasswordIsInvalidException("Username is null, blank or empty!");
        } else if (username.length() <= 4 || username.length() >= 24) {
            throw new LoginUsernameOrPasswordIsInvalidException("Username is too short or long!");
        }

        if (password == null || password.isBlank() || password.trim().isEmpty()) {
            throw new LoginUsernameOrPasswordIsInvalidException("Password is invalid.");
        } else if (password.length() <= 8 || password.length() >= 48) {
            throw new LoginUsernameOrPasswordIsInvalidException("Password is too short or long!");
        } else if (!matcher.find()) {
            throw new LoginUsernameOrPasswordIsInvalidException("Password must contains a special character!");
        }
        return true;
    }
}
