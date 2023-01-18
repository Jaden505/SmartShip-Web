package com.server.server.rest;

import com.server.server.model.PasswordResetToken;
import com.server.server.payload.request.ChangePasswordRequest;
import com.server.server.payload.request.LoginRequest;
import com.server.server.payload.response.JwtResponse;
import com.server.server.repository.PasswordTokenRepository;
import com.server.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    @Autowired
    CommandLineRunner dataLoader;

    List<PasswordResetToken> passwordResetTokenList;

    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.passwordResetTokenList = passwordTokenRepository.findAll();
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void login() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user5");
        loginRequest.setPassword("password");
        ResponseEntity<JwtResponse> response = restTemplate.postForEntity("/api/auth/signin", loginRequest, JwtResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user5", response.getBody().getUsername());

    }

    @Test
    public void loginFail() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user5");
        loginRequest.setPassword("password1");
        ResponseEntity<JwtResponse> response = restTemplate.postForEntity("/api/auth/signin", loginRequest, JwtResponse.class);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }

    @Test
    public void userShouldBeAbleToChangeHisPassword() {

        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setNew_password("newPassword");

        PasswordResetToken passwordResetToken = this.passwordResetTokenList.get(0);

        assertTrue(encoder.matches("password", passwordResetToken.getUser().getPassword()));

        ResponseEntity<?> response = restTemplate.postForEntity("/api/auth/changePassword?token=" + passwordResetToken.getToken(), changePasswordRequest, PasswordResetToken.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(encoder.matches("newPassword", userRepository.findById(passwordResetToken.getUser().getId()).get().getPassword()));


    }



}
