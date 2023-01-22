package com.server.server.rest;

import com.server.server.model.Ship;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShipControllerTest {

    // Import TestRestTemplate class for testing the REST API
    @Autowired
    private TestRestTemplate restTemplate;

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
    }

    @Test
    public void getAllShips() {
        // Send a GET request to the REST API
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/ships/all", List.class);

        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        System.out.println(response);

        // Check if the response body is not null
        assertNotNull(response.getBody());
    }

    @Test
    public void getShipById() {
        // Send a GET request to the REST API
        ResponseEntity<List> response = restTemplate.getForEntity("/api/test/ships/ship0", List.class);

        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Check if the response body is not null
        assertNotNull(response.getBody());
    }

    @Test
    public void addNewShip() {
        // Declare new sensor data and assign it to a new sensor data object
        Ship shipData = new Ship();
        shipData.setId("12");
        shipData.setStatus("ACTIVE");
        shipData.setGpsLatitude("24.123");
        shipData.setGpsLongtitude("24.123");
        shipData.setName("Maria");
        shipData.setTank1(100);
        shipData.setTank2(100);

        // Send a POST request to the REST API with  sensor data object as the request body
        ResponseEntity<Ship> response = restTemplate.postForEntity("/api/test/ships/create", shipData, Ship.class);

        // Check if the response status is OK
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Check if the response body is not null
        assertEquals(shipData.getId(), Objects.requireNonNull(response.getBody()).getId());
    }
}
