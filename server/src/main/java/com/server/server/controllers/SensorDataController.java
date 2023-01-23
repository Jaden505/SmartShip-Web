package com.server.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.repository.SensorDataRepository;
import com.server.server.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/sensorData")
public class SensorDataController {

    @Autowired
    SensorData sensorData;

    @Autowired
    SensorDataRepository repo;

    @Autowired
    ShipRepository shipRepo;

    @GetMapping("/")
    public ResponseEntity<List<SensorData>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/Categories")
    public List<String> getCategories() {
        return repo.getCategories();
    }

//    @GetMapping("/Motor")
//    public List<String> getSensorNameByMotor() {
//        return repo.getSensorNameByMotor();
//    }
//
//    @GetMapping("/SeaConditions")
//    public List<String> getSensorNameBySeaConditions() {
//        return repo.getSensorNameBySeaConditions();
//    }
//
//    @GetMapping("/Fuel")
//    public List<String> getSensorNameByFuel() {
//        return repo.getSensorNameByFuel();
//    }
//
//    @GetMapping("/Battery")
//    public List<String> getSensorNameByBattery() {
//        return repo.getSensorNameByBattery();
//    }

    @GetMapping("/{ship_id}")
    public ResponseEntity<List<SensorData>> getByShipId(@PathVariable String ship_id){
        return ResponseEntity.ok(repo.findByShipId(ship_id));
    }

    @GetMapping("/Value/{group}/{sensorName}/{ship}")
    public List<String> getSensorValue(@PathVariable("group") String group, @PathVariable("sensorName")String sensorName, @PathVariable("ship")String ship){
        Ship foundship = shipRepo.getById(ship);
        System.out.println(sensorName);
        System.out.println(group);
        sensorName = sensorName.replaceAll("_", "\\ ");
        group = group.replaceAll("_", "\\ ");
        System.out.println(sensorName);
        System.out.println(group);
        return repo.getSensorValue(group, sensorName, foundship);
    }

    //new replacement for finding sensorname from group
    @GetMapping("/Value/{group}")
    public List<String> getSensorName(@PathVariable("group") String group){
        System.out.println(group);
        group = group.replaceAll("_", "\\ ");
        System.out.println(group);
        return repo.getSensorName(group);
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
