package com.server.server.controllers;

import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This class is responsible for handling the requests from the client
// and sending the appropriate response
// It is also responsible for handling the database operations

// This annotation is used to allow requests from any origin and to cache the preflight request for 3600 seconds
// This is required to allow requests from the client which is running on a different port (localhost: 8081)
@CrossOrigin(origins = "*", maxAge = 3600)

// This annotation is used to convert the response to JSON and also adds the @Controller and @ResponseBody annotations
@RestController

// This annotation is used to map the request to the specified URL
// The request will be handled by the method specified in the annotation
@RequestMapping("/api/test")
public class NotificationController {

    // This annotation is used to inject the dependency
    // It allows Spring to resolve and inject collaborating beans into our bean
    @Autowired
    private NotificationRepository notificationRepo;

    // This annotation is used to map the request to the specified URL
    // The request will be handled by the method specified in the annotation
    // The method will be called when the client sends a GET request to the URL /api/test/notifications
    // and return a list of notifications
    @GetMapping("/notification-overview")
    public List<Notification> allNotifications() {
        return notificationRepo.findAll();
    }
    // This annotation is used to map the request to the specified URL
    // The request will be handled by the method specified in the annotation
    // The method will be called when the client sends a DELETE request to the URL /api/test/notifications/{id}
    @DeleteMapping("/notification-overview/{id}")
    public ResponseEntity<Void> delete (@PathVariable int id) {
        notificationRepo.deleteById(id);
        // This method returns a response entity with the status code 204.
        // 204 is the status code for a successful request with no content
        // This is used to indicate that the request has succeeded,
        // but that the client doesn't need to go away from its current page to see the result
        return ResponseEntity.noContent().build();
    }

}



