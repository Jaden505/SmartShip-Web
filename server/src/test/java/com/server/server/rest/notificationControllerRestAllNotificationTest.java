package com.server.server.rest;

import com.server.server.ServerApplication;
import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class notificationControllerRestAllNotificationTest {

    @Autowired
    ServerApplication serverApplication = null;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private NotificationRepository notificationRepo;

    @BeforeEach
    public void setup(){
        List<Notification> notifications = this.notificationRepo.findAll();
        assertNotNull(notifications);
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
}
