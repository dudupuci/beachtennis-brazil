package br.com.beachtennisbrazil.api.system.javaxmail.templates;

import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import br.com.beachtennisbrazil.api.system.javaxmail.interfaces.RegisterTemplateInterface;

public class RegisterTemplateMapper implements RegisterTemplateInterface {

    @Override
    public String getRegisterSubject(TypeOfEmailSent typeOfEmailSent) {
        if (typeOfEmailSent == TypeOfEmailSent.ADMIN_REGISTRATION) {
            return TypeOfEmailSent.ADMIN_REGISTRATION.getValue();

        } else if (typeOfEmailSent == TypeOfEmailSent.PLAYER_REGISTRATION) {
            return TypeOfEmailSent.PLAYER_REGISTRATION.getValue();
        } else {
            return null;
        }
    }

    @Override
    public String getRegisterTextMessage(String loginOrDocument, String passwordOrAccessCode, TypeOfEmailSent typeOfEmailSent) {
        if (typeOfEmailSent == TypeOfEmailSent.ADMIN_REGISTRATION) {
            return "Access the dashboard system using: \n" +
                    "Login: " + loginOrDocument + "\n" +
                    "Password: " + passwordOrAccessCode + "\n" +
                    "URL: https://localhost:8190/admin/login";
        } else if (typeOfEmailSent == TypeOfEmailSent.PLAYER_REGISTRATION) {
            return "Access the dashboard system using: \n" +
                    "Document registered: " + loginOrDocument + "\n" +
                    "Access code (confidentially): " + passwordOrAccessCode + "\n" +
                    "URL: https://localhost:8190/player/login";
        } else {
            return null;
        }
    }
}
