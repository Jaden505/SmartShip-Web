package com.server.server.models;

import com.server.server.model.Ship;
import com.server.server.model.User;
import com.server.server.services.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShipTest {
    // Declare test variables - test ships and ships
    User user;
    Ship ship;

    // Declare an instance of the PasswordEncoder interface
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Before each test, create a new password reset tokens and users with the token value
    @BeforeEach
    public void setup() {
        user = User.createSampleUser(1, encoder.encode("password"));
        ship = Ship.createSampleShip(0);
    }

    @Test
    public void testAssignUserToShip() {
        // Assign the ship
        user.setShip(ship);

        // Test if correctly assigned to the user
        assertEquals(user.getShip(), ship);
    }

    @Test
    public void testShipData() {
        // Test if the ship is active
        assertEquals(ship.getStatus(), "ACTIVE");

        // Test if the ship tostring is correct
        assertEquals(ship.toString(), "[id=ship0, name=Ship 0, status=ACTIVE, gpsLatitude=10.0, gpsLongtitude=10.0, tank1=100, tank2=100]");
    }
}
