package com.server.server.models;

import com.server.server.model.PasswordResetToken;
import com.server.server.model.User;
import com.server.server.services.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordResetTokenTest {

    PasswordResetToken passwordResetToken1, passwordResetToken2;

    User user1, user2;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    MailService mailService;

    String token;

    @BeforeEach
    public void setup() {
        token = UUID.randomUUID().toString();

        user1 = User.createSampleUser(1, encoder.encode("password"));
        user2 = User.createSampleUser(2, encoder.encode("password"));

        this.passwordResetToken1 = new PasswordResetToken(token, user1, LocalDate.now());
        this.passwordResetToken2 = new PasswordResetToken(token, user2, LocalDate.of(2023, 1, 29));
    }

    @Test
    public void testGetToken() {
        assertEquals(this.token, this.passwordResetToken1.getToken());
        assertEquals(this.token, this.passwordResetToken2.getToken());

        assertEquals(this.user1, this.passwordResetToken1.getUser());
        assertEquals(this.user2, this.passwordResetToken2.getUser());

        assertNotEquals(this.passwordResetToken1.getUser().getPassword(), this.passwordResetToken2.getUser().getPassword());
    }

    @Test
    public void testSetToken() {
        String newToken = UUID.randomUUID().toString();
        this.passwordResetToken1.setToken(newToken);
        this.passwordResetToken2.setToken(newToken);

        assertEquals(newToken, this.passwordResetToken1.getToken());
        assertEquals(newToken, this.passwordResetToken2.getToken());
    }

    @Test
    public void validateToken() {
        assertFalse(mailService.isTokenExpired(this.passwordResetToken1));

        assertTrue(mailService.isTokenExpired(this.passwordResetToken2));
    }


}
