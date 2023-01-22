package com.server.server.controllers;

import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This annotation is used to allow requests from any origin and to cache the preflight request
// (check to see if the CORS protocol is understood) for 3600 seconds
@CrossOrigin(origins = "*", maxAge = 3600)

// This annotation is used to convert the response to JSON and also adds the @Controller and @ResponseBody annotations
@RestController

@RequestMapping("/api/test")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;

    @GetMapping("/notification-overview")
    public ResponseEntity<List<Notification>> allNotifications() {

        try{
            List<Notification> allNotifications = notificationRepo.findAll();

            return new ResponseEntity<>(allNotifications, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/notification-overview/{id}")
    public ResponseEntity<HttpStatus> delete (@PathVariable int id) {
        try {
            notificationRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}



