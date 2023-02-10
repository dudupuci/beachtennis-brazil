package br.com.beachtennisbrazil.api.system.javaxmail.interfaces;

import java.net.InetAddress;

public interface NewLoginCapturedTemplateInterface {
    String getSubject();
    String unknowIpAddress(InetAddress address);
}
