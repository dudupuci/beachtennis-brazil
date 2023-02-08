package br.com.beachtennisbrazil.api.system.javaxmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JavaxMailTemplateSender {
    private String to;
    private String from;
    private String host;
    private String port;

    public static void configuration(String to, String from) {
        JavaxMailTemplateSender mail = new JavaxMailTemplateSender();
        mail.setTo(to);
        mail.setFrom(from);
        mail.setHost("smtp-relay.sendinblue.com");
        mail.setPort("465");

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp-relay.sendinblue.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("dudupucinelli@gmail.com", "4G0XNHhmzFdP9WT2");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");
            // Now set the actual message
            message.setText("This is actual message");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}