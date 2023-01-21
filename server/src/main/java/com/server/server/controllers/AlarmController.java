package com.server.server.controllers;

import com.server.server.model.Alarm;
import com.server.server.model.Notification;
import com.server.server.model.SensorData;
import com.server.server.repository.AlarmRepository;
import com.server.server.repository.NotificationRepository;
import org.apache.el.parser.AstLambdaExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AlarmController {

    @Autowired
    AlarmRepository alarmRepo;

    @Autowired
    NotificationRepository notificationRepo;

    @GetMapping("/Alarms")
    public List<Alarm> allNotifications(Model alarm) {
        alarm.addAttribute("Alarms",alarmRepo.findAll());
        return alarmRepo.findAll();
    }

    @DeleteMapping("/Alarms/{index}")
    public ResponseEntity<Void> delete (@PathVariable int index) {
        alarmRepo.deleteById(index);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Alarms")
    public ResponseEntity<Alarm> addAlarms(@RequestBody Alarm alarm){
        try{
            return new ResponseEntity<>(alarmRepo.save(alarm), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/Alarms/send")
    public ResponseEntity<Notification> postNotification(@RequestBody Alarm alarm){
        try{
            Notification notification = new Notification(alarm.getParameter(), alarm.getCategory(),
                    alarm.getSettedUpValue(), alarm.getShipId(),alarm.getDate(),alarm.getMessage(),alarm.getUnit());
            return new ResponseEntity<>(notificationRepo.save(notification), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}



