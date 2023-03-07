package br.com.beachtennisbrazil.api.system.enums;

public enum TypeOfEmailSent {
    ADMIN_REGISTRATION("Admin Registration"),
    PLAYER_REGISTRATION("Player Registration"),
    CONFIRMATION("Confirmation"),
    NEW_LOGIN_CAPTURED("New Login Captured"),
    REQUEST("Request");

    private String value;

    TypeOfEmailSent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
