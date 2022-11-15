package com.server.server.controllers;

import com.server.server.model.Alarm;
import com.server.server.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AlarmRepository alarmRepo;

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

//    @PutMapping("/Alarms/{index}")
//    public Optional<Alarm> updateAlarm(@RequestBody Alarm alarm){
//        alarmRepo.save(alarm);
//        return alarmRepo.findById(alarm.getId());
//    }
//
//    @PostMapping("/Alarms/{alarm}")
//    public Optional<Alarm> addAlarm(@PathVariable Alarm alarm){
//        alarmRepo.save(alarm);
//        return alarmRepo.findById(alarm.getId());
//    }



}



