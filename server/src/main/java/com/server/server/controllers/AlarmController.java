package com.server.server.controllers;

import com.server.server.model.Alarm;
import com.server.server.repository.AlarmRepository;
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

    @RequestMapping(value = "/Alarms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Alarm> updateAlarm( @PathVariable int id, @RequestBody Alarm alarm){
        Optional<Alarm> alarmData = alarmRepo.findById(id);

        if(alarmData.isPresent()){
            Alarm _alarm = alarmData.get();
            _alarm.setParameter(alarm.getParameter());
            _alarm.setCategory(alarm.getCategory());
            _alarm.setValueSinceLastUpdate(alarm.getValueSinceLastUpdate());
            _alarm.setSettedUpValue(alarm.getSettedUpValue());
            _alarm.setShip_id(alarm.getShip_id());
            return new ResponseEntity<>(alarmRepo.save(_alarm), HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
    @PostMapping("/Alarms/{alarm}")
    public List<Alarm> addAlarms(@PathVariable Alarm alarm){
        alarmRepo.save(alarm);
        return alarmRepo.findAll();
    }


}


