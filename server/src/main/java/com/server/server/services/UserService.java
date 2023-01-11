package com.server.server.services;

import com.server.server.model.PasswordResetToken;
import com.server.server.model.User;
import com.server.server.repository.PasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class UserService {

    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    public void createPasswordResetTokenForUser(User user, String token, LocalDate expireDate) {
        PasswordResetToken myToken = new PasswordResetToken(token, user, expireDate);
        passwordTokenRepository.save(myToken);
        System.out.println(myToken);
    }

}

