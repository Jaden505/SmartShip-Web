package com.server.server.controllers;

import com.server.server.model.SensorData;
import com.server.server.repository.SensorDataRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpHeaders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorDataControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;

    private HttpEntity httpEntity;

    private Ship ship;

    private SensorData sensorData;

    private SensorDataController sensorDataController;

    private SensorDataRepository sensorDataRepository;

    @BeforeEach
//    public void create() {
//        sensorData = new SensorData("bb7baec4-c049-45c5-81ce-2715801e6bfffffff", "Battery", "Depletion Rate", "07202515-a483-464c-b704-5671f104044b", "2022-07-15 13:10:00.000000", "Depletion rate", "15", "KW/H", "12.8", "N52°3'53.754", "E3°40'53.123");
//
//        ResponseEntity<?> response =
//                this.restTemplate.getForEntity("/api/test/sensorData/Categories")
//    }

    @Test
    void getAll() {

    }

    @Test
    void getCategories() {
        ResponseEntity<String[]> response =
                this.restTemplate.exchange("/api/test/sensorData/Categories", HttpMethod.GET, httpEntity, String[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String categories = String.valueOf(response.getBody());

        assertThat(categories.length(), CoreMatchers.is(greaterThan(3)));
    }

    @Test
    void getByShipId() {

    }

    @Test
    void getSensorValue() {
        //value of matching name and group
        String group = "Battery";
        String ship_id = "Depletion Rate";
    }

    @Test
    void getSensorName() {
        String group = "Battery";
        String ship_id = "Depletion Rate";

        ResponseEntity<String[]> response =
                this.restTemplate.exchange("/api/test/sensorData/Value/{group}", HttpMethod.GET, httpEntity, String[].class, group);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String[] names = response.getBody();

        names[0].equals("percentage Left");

    }


    @Test
    void addSensorData() {
    }
}