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

    // Import User Repository class for handling all user related database operations
    @Autowired
    UserRepository userRepository;

    // Import Password Token Repository class for handling all password token related database operations
    @Autowired
    PasswordTokenRepository passwordTokenRepository;

    // Import DataLoader class for loading data into the database
    @Autowired
    CommandLineRunner dataLoader;

    // Declare a list of password reset tokens
    List<PasswordResetToken> passwordResetTokenList;

    // Before each test, load data into the database and assign password reset token list
    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.passwordResetTokenList = passwordTokenRepository.findAll();
    }

    // Declare an instance of BCryptPasswordEncoder class for encoding passwords
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Import TestRestTemplate class for testing the REST API
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void login() {
        // Create new Payload request class for signing in a user
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user5");
        loginRequest.setPassword("password");
        // Send a POST request to the login endpoint with the login request payload
        ResponseEntity<JwtResponse> response = restTemplate.postForEntity("/api/auth/signin", loginRequest, JwtResponse.class);

        // Assert that the response status code is 200
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Assert that the response body is not null
        assertEquals("user5", response.getBody().getUsername());

    }

    @Test
    public void loginFail() {
        // Create new Payload request class for signing in a user
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user5");
        loginRequest.setPassword("password1");
        // Send a POST request to the login endpoint with the login request payload
        ResponseEntity<JwtResponse> response = restTemplate.postForEntity("/api/auth/signin", loginRequest, JwtResponse.class);

        // Assert that the response status code is 401 - the user is not authorized and the credentials are incorrect
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }

    @Test
    public void userShouldBeAbleToChangeHisPassword() {
        // Create new Payload request class for changing a user's password
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setNew_password("newPassword");

        // Get the password reset token for the user
        PasswordResetToken passwordResetToken = this.passwordResetTokenList.get(0);

        // Send a POST request to the change password endpoint with the change password request payload
        assertTrue(encoder.matches("password", passwordResetToken.getUser().getPassword()));

        // Send a POST request to the change password endpoint with the change password request payload
        ResponseEntity<?> response = restTemplate.postForEntity("/api/auth/changePassword?token=" + passwordResetToken.getToken(), changePasswordRequest, PasswordResetToken.class);

        // Assert that the response status code is 200
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Assert that the password of the user has been changed
        assertTrue(encoder.matches("newPassword", userRepository.findById(passwordResetToken.getUser().getId()).get().getPassword()));


    }



}
