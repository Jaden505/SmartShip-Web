package com.server.server.controllers;

import com.server.server.model.Alarm;
import com.server.server.model.SensorData;
import com.server.server.repository.AlarmRepository;
import org.apache.el.parser.AstLambdaExpression;
import org.springframework.beans.factory.annotation.Autowired;
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
            Alarm _alarm = new Alarm(alarm.getParameter(), alarm.getCategory(), alarm.getSettedUpValue(), alarm.getShipId());
            return new ResponseEntity<>(alarmRepo.save(_alarm), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}



