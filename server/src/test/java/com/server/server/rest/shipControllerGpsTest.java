package com.server.server.rest;

import com.server.server.ServerApplication;
import com.server.server.model.Ship;
import com.server.server.repository.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class)
public class shipControllerGpsTest {

    @Autowired
    ServerApplication serverApplication = null;

    @Autowired
    private ShipRepository shipRepo;

    @BeforeEach
    public void setup(){
    }

    @Test
    public void checkGPSLatAndLong(){
        //Arrange
        List<Ship> ships = this.shipRepo.findAll();
        boolean value = false;

        //Act
        for (Ship ship : ships) {
            value = ship.getGpsLatitude() != null && ship.getGpsLongtitude() != null;
        }

        //Assert
        if(value){
            assertTrue(true);
            System.out.println("All the GPS latitudes and longitudes are filled in" +
                    " and the marker popup of the map can be displayed");
        }else{
            assertFalse(false);
            System.out.println("Not all the GPS latitudes and longitudes are filled in and it may happen that" +
                    " the marker popup of the map cannot be properly displayed");
        }
    }
}
