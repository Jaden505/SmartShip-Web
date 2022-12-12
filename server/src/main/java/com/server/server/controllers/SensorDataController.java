package com.server.server.controllers;

import com.server.server.model.SensorData;
import com.server.server.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/sensorData")
public class SensorDataController {

    @Autowired
    SensorData sensorData;

    @Autowired
    SensorDataRepository repo;

    @PostMapping("/add")
    public ResponseEntity<SensorData> addSensorData(@RequestBody SensorData body) {

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
