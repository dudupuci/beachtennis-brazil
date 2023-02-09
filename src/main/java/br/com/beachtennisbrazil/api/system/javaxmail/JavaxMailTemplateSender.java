package br.com.beachtennisbrazil.api.system.javaxmail;

import br.com.beachtennisbrazil.api.system.entities.SentEmail;
import br.com.beachtennisbrazil.api.system.enums.TypeOfEmailSent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.time.LocalDateTime;
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

    public static SentEmail configuration(String to, String from, String subject, String body) {
        SentEmail sentEmail = new SentEmail();
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
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            // Adding to db
            sentEmail.setMessage(body);
            sentEmail.setSubject(subject);
            sentEmail.setTo(to);
            sentEmail.setFrom(from);
            sentEmail.setSendedMoment(LocalDateTime.now());
            sentEmail.setTypeOfEmail(TypeOfEmailSent.REGISTRATION);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return sentEmail;
    }
}