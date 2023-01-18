package com.server.server.rest;

import com.server.server.ServerApplication;
import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class notificationControllerTest {

    @Autowired
    ServerApplication serverApplication = null;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private NotificationRepository notificationRepo;

    private List<Notification> notifications;

    @BeforeEach
    public void setup(){
        this.notifications = this.notificationRepo.findAll();
        assertNotNull(this.notifications);
    }

    @Test
    void contextLoads() {
        assertNotNull(serverApplication);
        System.out.println("The Application in running");
    }

    //Test a REST resource endpoint
    @Test
    public void allNotificationsREST(){
        //Arrange
        String message;

        //Act
        message = this.restTemplate.getForObject("/api/test/notification-overview", String.class);

        //Assert
        assertNotNull(message);
        System.out.println(message);
    }

    @Test
    public void checkForEntity(){
        //Arrange
        ResponseEntity<String> response;

        //Act
        response = this.restTemplate.getForEntity("/api/test/notification-overview", String.class);

        //Assert
        assertEquals(response.getStatusCodeValue(), HttpStatus.OK.value());
    }

}
