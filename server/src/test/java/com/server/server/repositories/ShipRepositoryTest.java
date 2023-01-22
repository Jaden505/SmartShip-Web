package com.server.server.repositories;

import com.server.server.model.Ship;
import com.server.server.repository.DataLoader;
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
public class ShipRepositoryTest {

    // Import Command Line Runner to load data into the database
    @Autowired
    CommandLineRunner dataLoader;

    // Import the repository for handling the ship actions
    @Autowired
    private ShipRepository shipRepository;

    // Declare a list for all ships
    private List<Ship> shipList;

    // Before each test, load the data into the database and assigned data to the correct list instance
    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.shipList = this.shipRepository.findAll();
    }

    @Test
    public void findAllShips() {
        // Assert that the list of sensor data is not empty
        assertTrue(this.shipList.size() > 0);
        assertEquals(3, this.shipList.size());
    }

    @Test
    public void findShipById() {
        // Assert that the list of sensor data is not empty
        List<Ship> shipsById = this.shipRepository.findShipById("ship2");
        // Loads the data for non-existing value
        List<Ship> nonExistingShip = this.shipRepository.findShipById("non-existing");

        // Assert that ships by id is not empty and has the correct size
        assertEquals(shipsById.size(), 1);
        assertEquals(shipsById.get(0).getId(), "ship2");

        // The value for non-existing value should be an empty list
        assertTrue(nonExistingShip.isEmpty());
    }
}
