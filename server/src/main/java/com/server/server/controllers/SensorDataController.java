package com.server.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.server.model.SensorData;
import com.server.server.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/sensorData")
public class SensorDataController {

    @Autowired
    SensorData sensorData;

    @Autowired
    SensorDataRepository repo;

    @GetMapping("/")
    public ResponseEntity<List<SensorData>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/Categories")
    public List<String> getCategories() {
        return repo.getCategories();
    }

    @GetMapping("/{ship_id}")
    public ResponseEntity<List<SensorData>> getByShipId(@PathVariable String ship_id){
        return ResponseEntity.ok(repo.findByShipId(ship_id));
    }

    @PostMapping("/add")
    public ResponseEntity<SensorData> addSensorData(@RequestBody SensorData body) {

//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            sensorData.setShip(mapper.writeValueAsString(body.getShip()));
//        }catch (JsonProcessingException e){
//            System.out.println("Json Processing");
//        }
        sensorData.setSensorId(body.getSensorId());
        sensorData.setGroup(body.getGroup());
        sensorData.setSensorName(body.getSensorName());
        sensorData.setShip(body.getShip());
        sensorData.setTime(body.getTime());
        sensorData.setType(body.getType());
        sensorData.setValue(body.getValue());
        sensorData.setUnit(body.getUnit());
        sensorData.setSpeed(body.getSpeed());
        sensorData.setGpsLatitude(body.getGpsLatitude());
        sensorData.setGpsLongtitude(body.getGpsLongtitude());

        try {
            SensorData sensorDataSave = repo.save(sensorData);
            return new ResponseEntity<>(sensorDataSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
