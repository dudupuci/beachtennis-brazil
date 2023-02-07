package br.com.beachtennisbrazil.api.system.enums;

public enum CollaboratorPaper {
    CARETAKER("Caretaker"),
    COOKER("Cooker"),
    CONCIERGE("Concierge"),
    VALET_PARKING("Valet Parking"),
    MANAGER("Manager"),
    ASSISTANT("Assistant"),
    COACH("Coach"),
    INTERN("Intern"),
    PARTNER("Partner");

    private String value;
    CollaboratorPaper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
