package com.server.server.repository;

import com.server.server.repository.SensorDataRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SensorDataRepositoryTest {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    private List<String> categories;

    @BeforeEach
    public void setup(){
        categories = this.sensorDataRepository.getCategories();
    }

    @Test
    void findByShipId() {
    }

    @Test
    public void getCategories() {
        assertThat(categories.size(), CoreMatchers.is(greaterThan(1)));
    }

//    @Test
//    //met motor bedoel ik category btw
//    void getSensorNameByMotor() {
//        String categoryType = "Motor";
//        String category = this.sensorDataRepository.getSensorNameByMotor(categoryType);
//
//        assertThat(categoryType, category.);
//    }

    @Test
    void getSensorNameBySeaConditions() {
    }

    @Test
    void getSensorNameByFuel() {
    }

    @Test
    void getSensorNameByBattery() {
    }

    @Test
    void getSensorValue() {
    }

    @Test
    void getSensorName() {
    }
}