package br.com.beachtennisbrazil.api.system.entities.validation;

import br.com.beachtennisbrazil.api.system.entities.validation.interfaces.RegisterValidatorInterface;
import br.com.beachtennisbrazil.api.system.exceptions.*;
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
    public boolean validateFields(String username, String password, String confirmPassword, String email) {
        Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
        Pattern emailFormat = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
        Matcher matcher = specialCharacters.matcher(password);
        Matcher emailMatcher = emailFormat.matcher(email);

        if (username == null || username.isBlank() || username.trim().isEmpty()) {
            throw new InvalidUsernameException("Username is null, blank or empty!");
        } else if (username.length() <= 4 || username.length() >= 24) {
            throw new InvalidUsernameException("Username is too short or long!");
        }

        if (!confirmPassword.equals(password)) {
            throw new ConfirmationPasswordDoesNotMatchThePassword("Confirmation password does not match the password.");
        }

        if (!emailMatcher.find() || email.length() < 6) {
            throw new InvalidEmailException("Please, verify the email format and try again.");
        }

        if (password == null || password.isBlank() || password.trim().isEmpty()) {
            throw new InvalidPasswordException("Password is invalid.");
        } else if (password.length() <= 8 || password.length() >= 48) {
            throw new InvalidPasswordException("Password is too short or long!");
        } else if (confirmPassword == null || confirmPassword.isBlank() || confirmPassword.trim().isEmpty()) {
            throw new InvalidConfirmationPasswordException("Please, confirm your password!");
        } else if (!matcher.find()) {
            throw new SpecialCharacterNotFoundException("Password must contains a special character!");
        }
        return true;
    }
}
