package com.server.server.repositories;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.repository.DataLoader;
import com.server.server.repository.SensorDataRepository;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(DataLoader.class)
public class SensorDataRepositoryTest {

    // Import Command Line Runner to load data into the database
    @Autowired
    CommandLineRunner dataLoader;

    // Import the repository for handling the sensor data actions
    @Autowired
    private SensorDataRepository sensorDataRepository;

    // Import the repository for handling the ship actions
    @Autowired
    private ShipRepository shipRepository;

    // Declare a list for all sensor data
    private List<SensorData> sensorDataList;

    // Declare a list for all ships
    private List<Ship> shipList;

    // Before each test, load the data into the database and assigned data to the correct list instance
    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.sensorDataList = this.sensorDataRepository.findAll();
        this.shipList = this.shipRepository.findAll();
    }

    @Test
    public void findAllSensorData() {
        // Assert that the list of sensor data is not empty
        assertTrue(this.sensorDataList.size() > 0);
        assertEquals(3, this.shipList.size());
    }

    @Test
    public void findAllSensorDataByShipId() {
        // Assert that the list of sensor data is not empty
        List<SensorData> sensorData = this.sensorDataRepository.findByShipId("ship2");
        // Loads the data for non existing value
        List<SensorData> nonExistingSensorData = this.sensorDataRepository.findByShipId("non-existing");

        assertEquals(5, sensorData.size());
        assertEquals("sensorId0", sensorData.get(0).getSensorId());
        // The value for non existing value should be an empty list
        assertTrue(nonExistingSensorData.isEmpty());
    }

}
