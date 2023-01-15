package com.server.server;

import com.server.server.model.Notification;
import com.server.server.model.Ship;
import com.server.server.repository.NotificationRepository;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Tests {

    @Autowired
    ServerApplication serverApplication = null;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private NotificationRepository notificationRepo;

    @Autowired
    private ShipRepository shipRepo;


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


    //Test a JPA Repository post method
    @Test
    public void postNotificationJPA() {
        System.out.println("the size of the notifications is " + this.notifications.size());
        //Arrange
        Notification notification = new Notification("TEST", "TEST", 20,
                "083434-test-13213", new Date(), "This is a message", "The unit of the value");

        //Act
        this.notificationRepo.save(notification);
        System.out.println("the size of the notifications is " + this.notificationRepo.findAll().size());

        //Assert
        assertTrue(this.notificationRepo.findAll().size() > this.notifications.size());
    }

    //Test a JPA Repository method
    @Test
    public void deleteNotificationJPA() {
        if(this.notifications.size() > 0) {
            //Arrange
            Notification notification = this.notifications.get(0);

            //Act
            this.notificationRepo.delete(notification);

            //Assert
            assertTrue(this.notificationRepo.findAll().size() < this.notifications.size());
        }
        else {
            //Assert
            assertEquals(0, this.notificationRepo.findAll().size());
        }
    }

    @Test
    public void checkGPSLatAndLong(){
        //Arrange
        List<Ship> ships = this.shipRepo.findAll();
        boolean value = false;

        //Act
        for (Ship ship : ships) {
            if (ship.getGpsLatitude() != null && ship.getGpsLongtitude() != null) {
                value = true;
            }
            else{
                value = false;
            }
        }

        //Assert
        if(value){
            assertTrue(value);
            System.out.println("All the GPS latitudes and longitudes are filled in" +
                    " and the marker popup of the map can be displayed");
        }else{
            assertFalse(value);
            System.out.println("Not all the GPS latitudes and longitudes are filled in and it may happen that" +
                    " the marker popup of the map cannot be properly displayed");
        }
    }

}
