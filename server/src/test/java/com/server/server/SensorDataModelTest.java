package com.server.server;

import com.server.server.model.SensorData;
import com.server.server.model.Ship;
import com.server.server.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class SensorDataModelTest {

    SensorData sensorData1, sensorData2;
    Ship ship;

    @BeforeEach
    public void setup(){
        ship = new Ship("07202515-a483-464c-b704-5671f104044b", "Serendipity", new Status(1L, "IDLE"),
                "N52°3'53.754", "E3°40'53.123", 10,10);

        sensorData1 = new SensorData("bb7baec4-c049-45c5-81ce-27158016bfff", "Fuel",
                "Depletion Rate", ship, LocalDateTime.now(), "Depletion rate",
                "15", "T/H", "12.8", "N52°3'53.754", "E3°40'53.123");

        sensorData2 = new SensorData("bb7baec4-c049-45c5-81ce-27158016bffff", "Fuel",
                "Depletion Rate", ship, LocalDateTime.now(), "Depletion rate",
                "20", "T/H", "12.8", "N52°3'53.754", "E3°40'53.123");
    }

    @Test
    @DisplayName("SensorData value Test")
    public void valueSensorData(){
        assertNotEquals(sensorData1.getValue(), sensorData2.getValue());

        double value1 = Double.parseDouble(sensorData1.getValue());
        double value2 = Double.parseDouble(sensorData2.getValue());

        assertEquals(value1, value2, 5);

    }

    @Test
    @DisplayName("SensorData speed Test")
    public void speedSensorData(){
        assertEquals(sensorData1.getSpeed(), sensorData2.getSpeed());
    }

    @Test
    @DisplayName("SensorData id Test")
    public void idSensorData(){
        assertNotEquals(sensorData1.getSensorId(), sensorData2.getSensorId());
    }
}
