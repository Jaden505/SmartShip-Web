package com.server.server.models;

import com.server.server.model.PasswordResetToken;
import com.server.server.model.User;
import com.server.server.services.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordResetTokenTest {

    // Declare test variables - test password reset tokens
    PasswordResetToken passwordResetToken1, passwordResetToken2;

    // Declare test variables - test users
    User user1, user2;

    // Declare an instance of the PasswordEncoder interface
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Declare an instance of the MailService class
    @Autowired
    MailService mailService;

    // Declare test variable - token with random UUID
    String token;

    // Before each test, create a new password reset tokens and users with the token value
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
        // Test that the token value assigned to the password reset token is the same as the token value
        assertEquals(this.token, this.passwordResetToken1.getToken());
        assertEquals(this.token, this.passwordResetToken2.getToken());

        // Check if the correct user has been assigned to the password reset token
        assertEquals(this.user1, this.passwordResetToken1.getUser());
        assertEquals(this.user2, this.passwordResetToken2.getUser());

        // Check if the encryption works properly and creates two different hashed passwords for the same value
        assertNotEquals(this.passwordResetToken1.getUser().getPassword(), this.passwordResetToken2.getUser().getPassword());
    }

    @Test
    public void testSetToken() {
        // Check if the token value can be changed with the setter method
        String newToken = UUID.randomUUID().toString();
        this.passwordResetToken1.setToken(newToken);
        this.passwordResetToken2.setToken(newToken);

        // Check if the token value has been changed
        assertEquals(newToken, this.passwordResetToken1.getToken());
        assertEquals(newToken, this.passwordResetToken2.getToken());
    }

    @Test
    public void validateToken() {
        // Check if the token is valid - this test only test on expiry date not the existence of token in the repository
        assertFalse(mailService.isTokenExpired(this.passwordResetToken1));
        assertTrue(mailService.isTokenExpired(this.passwordResetToken2));
    }

}
