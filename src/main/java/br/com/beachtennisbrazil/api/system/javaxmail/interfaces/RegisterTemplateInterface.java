package br.com.beachtennisbrazil.api.system.javaxmail.interfaces;

import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;

public interface RegisterTemplateInterface {
    String getRegisterSubject(TypeOfEmailSent typeOfEmailSent);
    String getRegisterTextMessage(String loginOrDocument, String passwordOrAccessCode, TypeOfEmailSent typeOfEmailSent);
}
