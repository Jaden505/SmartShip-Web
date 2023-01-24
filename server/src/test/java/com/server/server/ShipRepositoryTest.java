package com.server.server;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.model.Status;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShipRepositoryTest {

    @Autowired
    private ShipRepository shipRepository;

    private Ship ship;

    @BeforeEach
    public void setup(){
        ship = new Ship("07202515-a483-464c-b704-5671f104044bb", "Serendipity", new Status(1L, "IDLE"),
                "N52°3'53.754", "E3°40'53.123", 10,10);

    }

    @Test
    @DisplayName("Name test")
    public void sensorDataSave() {
        assertEquals(ship.getName(), "Serendipity");

        ship.setName("Ose");

        assertEquals(ship.getName(), "Ose");
    }

//
    @Test
    @DisplayName("findAll test")
    public void sensorDataFindAll() {
        List<Ship> findAll = shipRepository.findAll();

        assertEquals(findAll.get(1).getName(), "Imagination");

        assertEquals(findAll.get(0).getTank1(), 10);
    }
}
