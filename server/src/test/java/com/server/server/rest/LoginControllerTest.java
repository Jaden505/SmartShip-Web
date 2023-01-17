package com.server.server.rest;

import com.server.server.payload.request.LoginRequest;
import com.server.server.payload.response.JwtResponse;
import com.server.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommandLineRunner dataLoader;

    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
    }

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

}
