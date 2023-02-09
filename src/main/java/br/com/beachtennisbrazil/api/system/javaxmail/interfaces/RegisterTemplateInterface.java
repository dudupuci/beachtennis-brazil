package br.com.beachtennisbrazil.api.system.javaxmail.interfaces;

public interface RegisterTemplateInterface {
    String getSubject();
    String getTextMessage(String username, String password);
}
