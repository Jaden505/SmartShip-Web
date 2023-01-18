package com.server.server.repositories;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.model.User;
import com.server.server.repository.DataLoader;
import com.server.server.repository.SensorDataRepository;
import com.server.server.repository.ShipRepository;
import com.server.server.repository.UserRepository;
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

    @Autowired
    CommandLineRunner dataLoader;

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private ShipRepository shipRepository;

    private List<SensorData> sensorDataList;

    private List<Ship> shipList;

    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.sensorDataList = this.sensorDataRepository.findAll();
        this.shipList = this.shipRepository.findAll();
    }

    @Test
    public void findAllSensorData() {
        assertTrue(this.sensorDataList.size() > 0);
        assertEquals(3, this.shipList.size());
    }

    @Test
    public void findAllSensorDataByShipId() {
        for (SensorData sensorData: this.sensorDataList) {
            System.out.println(sensorData.getShip().getId());
        }

        for (Ship ship: shipList) {
            List<SensorData> sensorData = this.sensorDataRepository.findByShipId(ship.getId());
            System.out.println(sensorData);
        }

        List<SensorData> sensorData = this.sensorDataRepository.findByShipId("non-existing");
        assertNull(sensorData);
    }

}
