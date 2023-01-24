package com.server.server;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.model.Status;
import com.server.server.repository.SensorDataRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorDataRepositoryTest {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    private SensorData sensorData;

    private Ship ship;

    @BeforeEach
    public void setup(){
        ship = new Ship("07202515-a483-464c-b704-5671f104044b", "Serendipity", new Status(1L, "IDLE"),
                "N52°3'53.754", "E3°40'53.123", 10,10);

        sensorData = new SensorData("bb7baec4-c049-45c5-81ce-27158016bfff", "Fuel",
                "Depletion Rate", ship, LocalDateTime.now(), "Depletion rate",
                "15", "T/H", "12.8", "N52°3'53.754", "E3°40'53.123");

    }

    @Test
    @DisplayName("Sensor Save test")
    public void sensorDataSave() {
        sensorData.setSpeed("100");

        // Save data
        SensorData savedData = sensorDataRepository.save(sensorData);

        assertEquals(savedData.getSpeed(), "100");
        assertEquals(savedData.getGroup(), "Fuel");
    }

    @Test
    @DisplayName("Sensor Save 2 test")
    public void sensorDataSave2() {
        // Save data
        SensorData savedData = sensorDataRepository.save(sensorData);

        assertTrue(sensorData.getSensorId() != null || sensorData.getSensorId().isEmpty());
        assertEquals("Depletion rate", savedData.getType());
    }

    @Test
    @DisplayName("findAll test")
    public void sensorDataFindAll() {
        List<SensorData> findAll = sensorDataRepository.findAll();

        // check group
        assertEquals(findAll.get(0).getGroup(), "Motor");

        // check amount of groups
        assertEquals(sensorDataRepository.getCategories().size(), 4);
    }
}
