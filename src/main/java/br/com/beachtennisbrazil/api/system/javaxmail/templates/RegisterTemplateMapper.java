package br.com.beachtennisbrazil.api.system.javaxmail.templates;

import br.com.beachtennisbrazil.api.system.javaxmail.interfaces.RegisterTemplateInterface;

public class RegisterTemplateMapper implements RegisterTemplateInterface {

    @Override
    public String getSubject() {
        return "Register subject!";
    }

    @Override
    public String getTextMessage(String username, String password) {
        return "Congratulations brother! "+username + " and your password is: "+password;
    }
}
