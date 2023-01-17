package com.server.server.rest;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.repository.SensorDataRepository;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithUserDetails;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorDataControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    SensorDataRepository sensorDataRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    CommandLineRunner dataLoader;

    List<Ship> ships;

    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.ships = this.shipRepository.findAll();
    }

    @Test
    public void getAllSensorData() {
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/sensorData/", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5, response.getBody().size());
    }

    @Test
    public void getSensorDataForSpecificShip() {
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/sensorData/ship2", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5, response.getBody().size());
    }

    @Test
    public void addNewSensorData() {

        Ship ship = this.ships.get(0);

        System.out.println(ship.getStatus());

        SensorData sensorData = new SensorData();
        sensorData.setSensorId("sensor1");
        sensorData.setGroup("Motor");
        sensorData.setType("Temperature");
        sensorData.setValue("1.0");
        sensorData.setUnit("kW");
        sensorData.setShip(ship);
        sensorData.setSensorName("Motor 1");
        sensorData.setTime(LocalDateTime.now());
        sensorData.setSpeed("99");
        sensorData.setGpsLatitude("99");
        sensorData.setGpsLongtitude("99");

        ResponseEntity<SensorData> response = restTemplate.postForEntity("/api/test/sensorData/add", sensorData, SensorData.class);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        System.out.println(response.getBody());

    }


}
