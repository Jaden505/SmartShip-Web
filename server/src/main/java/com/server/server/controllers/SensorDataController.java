package com.server.server.controllers;

import com.server.server.model.SensorData;
import com.server.server.payload.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sensorData")
public class SensorDataController {


    @PostMapping("/add")
    public ResponseEntity<?> addSensorData(@RequestBody SensorData sensorData) {



        return ResponseEntity.created()
                .body();

    }


}
