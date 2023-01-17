package com.server.server.services;

import com.server.server.model.PasswordResetToken;
import com.server.server.model.User;
import com.server.server.repository.PasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    public void constructResetTokenEmail(
            String contextPath, String token, User user) {
        String url = contextPath + "/#/changePassword?token=" + token;
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

    public PasswordResetToken validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? null
                : isTokenExpired(passToken) ? null
                : passToken;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    public boolean isTokenExpired(PasswordResetToken passToken) {
        LocalDate expirationDate = LocalDate.now(ZoneId.systemDefault());

        return passToken.getExpiryDate().isAfter(expirationDate);
    }

}

