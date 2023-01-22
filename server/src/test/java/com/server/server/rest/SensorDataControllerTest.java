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
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorDataControllerTest {

    // Import TestRestTemplate class for testing the REST API
    @Autowired
    private TestRestTemplate restTemplate;

    // Import SensorData Repository class for handling all sensor data related database operations
    @Autowired
    SensorDataRepository sensorDataRepository;

    // Import Ship Repository class for handling all ship related database operations
    @Autowired
    ShipRepository shipRepository;

    // Import DataLoader class for loading data into the database
    @Autowired
    CommandLineRunner dataLoader;

    // Declare a list of ships
    List<Ship> ships;

    // Before each test, load data into the database and assign ship list
    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.ships = this.shipRepository.findAll();
    }

    @Test
    public void getAllSensorData() {
        // Send a GET request to the REST API
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/sensorData/", List.class);
        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Check if the response body is not null
        assertEquals(6, response.getBody().size());
    }

    @Test
    public void getSensorDataForSpecificShip() {
        // Send a GET request to the REST API
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/sensorData/ship2", List.class);
        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Check if the response body is not null
        assertEquals(5, response.getBody().size());
    }

    @Test
    public void addNewSensorData() {
        // Declare new ship and assign it to the first ship from ships list
        Ship ship = this.ships.get(0);

        // Declare new sensor data and assign it to a new sensor data object
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

        // Send a POST request to the REST API with  sensor data object as the request body
        ResponseEntity<SensorData> response = restTemplate.postForEntity("/api/test/sensorData/add", sensorData, SensorData.class);

        // Check if the response status is OK
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Check if the response body is not null
        assertEquals(sensorData.getSensorId(), Objects.requireNonNull(response.getBody()).getSensorId());

    }


}
