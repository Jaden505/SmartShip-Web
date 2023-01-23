package com.server.server.repositories;

import com.server.server.ServerApplication;
import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class notificationRepositoryPostNotificationTest {

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
    public void postNotificationJPA() {
        System.out.println("the size of the notifications is " + this.notifications.size());
        //Arrange
        Notification notification = new Notification("Notification", "Notificaition", 20,
                "3002", new Date(), "This is a message", "The unit of the value");

        //Act
        this.notificationRepo.save(notification);
        System.out.println("the size of the notifications is " + this.notificationRepo.findAll().size());
        System.out.println("All the notifications: " + this.notificationRepo.findAll());

        //Assert
        assertTrue(this.notificationRepo.findAll().size() > this.notifications.size());
    }
}
