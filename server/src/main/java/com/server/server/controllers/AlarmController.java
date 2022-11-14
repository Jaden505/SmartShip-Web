package com.server.server.controllers;

import com.server.server.model.Alarm;
import com.server.server.repository.AlarmRepository;
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
public class AlarmController {

    @Autowired
    private AlarmRepository alarmRepo;

    @GetMapping("/Alarms")
    public List<Alarm> allNotifications(Model alarm) {
        alarm.addAttribute("Alarms",alarmRepo.findAll());
        return alarmRepo.findAll();
    }


}



