package com.server.server.services;

import com.server.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void constructResetTokenEmail(
            String contextPath, String token, User user) {
        String url = contextPath + "/changePassword?token=" + token;
        constructEmail("Reset Password", " \r\n" + url, user);
    }

    private void constructEmail(String subject, String body,
                                             User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom("noreply@smartship.com");
        emailSender.send(email);

        System.out.println("Mail sent successfully");
    }

}
