package com.server.server.controllers;

import com.server.server.model.Notification;
import com.server.server.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;

    @GetMapping("/NotificationOverview")
    public List<Notification> allNotifications(Model notification) {
        notification.addAttribute("Notification",notificationRepo.findAll());
        return notificationRepo.findAll();
    }


}



