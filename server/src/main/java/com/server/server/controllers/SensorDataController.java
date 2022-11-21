package com.server.server.controllers;

import com.server.server.model.SensorData;
import com.server.server.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class SensorDataController {
        @Autowired
        private SensorRepository sensorRepository;

        @GetMapping("/sensor_data")
        public List<SensorData> getEngine(){
            return sensorRepository.findAll();
        }
}
