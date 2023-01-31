package br.com.beachtennisbrazil.api.system.validation;

import br.com.beachtennisbrazil.api.system.validation.interfaces.LoginValidatorInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class LoginValidator implements LoginValidatorInterface {

    @Override
    public boolean validateUsername(String username) {
        if (username == null || username.isBlank() || username.trim().isEmpty()) {
            return false;
        } if (username.length() <= 4 || username.length() >= 24) {
            return false;
        } if (username.startsWith(String.valueOf(Integer.class))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        Pattern specialCharacters = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = specialCharacters.matcher(password);
        if (password == null || password.isBlank() || password.trim().isEmpty()) {
            return false;
        } if (password.length() <= 8 || password.length() >= 48) {
            return false;
        } if (!matcher.find()) {
            return false;
        }
        return true;
    }
}
