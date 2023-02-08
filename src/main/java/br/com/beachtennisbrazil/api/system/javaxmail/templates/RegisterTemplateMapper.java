package br.com.beachtennisbrazil.api.system.javaxmail.templates;

public class RegisterTemplateMapper {

    public static String welcomeMessage(String username) {
        return "Thanks for your registration, welcome system "+username;
    }
    public static String getRegistrationSubject() {
        return "Registration successfully!";
    }
}
