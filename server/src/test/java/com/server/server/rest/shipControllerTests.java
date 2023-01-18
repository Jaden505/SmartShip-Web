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

@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class shipControllerTests {

    @Autowired
    ServerApplication serverApplication = null;

    @Autowired
    private ShipRepository shipRepo;

    @BeforeEach
    public void setup(){
    }

    @Test
    void contextLoads() {
        assertNotNull(serverApplication);
        System.out.println("Application auto-configuration has succeeded");
    }

    @Test
    public void checkGPSLatAndLong(){
        //Arrange
        List<Ship> ships = this.shipRepo.findAll();
        boolean value = false;

        //Act
        for (Ship ship : ships) {
            if (ship.getGpsLatitude() != null && ship.getGpsLongtitude() != null) {
                value = true;
            }
            else{
                value = false;
            }
        }

        //Assert
        if(value){
            assertTrue(value, "All the GPS latitudes and longitudes are filled in" +
                    " and the marker popup of the map can be displayed");
        }else{
            assertFalse(value,"Not all the GPS latitudes and longitudes are filled in and it may happen that" +
                    " the marker popup of the map cannot be properly displayed");
        }
    }
    @Test
    public void checkTank1AndTank2(){
        //Arrange
        List<Ship> ships = this.shipRepo.findAll();
        boolean value = false;

        //Act
        for (Ship ship : ships) {
            if (ship.getTank1() != null && ship.getTank2() != null) {
                value = true;
            }
            else{
                value = false;
            }
        }

        //Assert
        if(value){
            assertTrue(value,"All the tank values of tank 1 and two are filled in" +
                    " and the graph on ship overview can be displayed");
        }else{
            assertFalse(value,"Not all the tank values of tank1 and tank2 are filled in and it may happen that" +
                    " the graph on ship overview cannot be properly displayed");
        }
    }
}
