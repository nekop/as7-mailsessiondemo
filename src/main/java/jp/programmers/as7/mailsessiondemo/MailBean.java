package jp.programmers.as7.mailsessiondemo;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.inject.Named;
import javax.annotation.Resource;

@Named
public class MailBean {
    @Resource(mappedName="java:jboss/mail/Default")
    Session session;

    public void sendTestMessage() throws Exception {
        String from = "nekop+from@localhost";
        String to = "nekop+to@localhost";
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Hello JavaMail");
        message.setText("Welcome to JavaMail");
        Transport.send(message);

        System.out.println("おくったよ！");
    }
    
}
