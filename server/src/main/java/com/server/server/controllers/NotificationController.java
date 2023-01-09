package com.server.server.controllers;

import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;

    @GetMapping("/notification-overview")
    public List<Notification> allNotifications() {
        return notificationRepo.findAll();
    }
    @DeleteMapping("/notification-overview/{index}")
    public ResponseEntity<Void> delete (@PathVariable int index) {
        notificationRepo.deleteById(index);
        return ResponseEntity.noContent().build();
    }

}



