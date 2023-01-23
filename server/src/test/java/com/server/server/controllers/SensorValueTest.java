package com.server.server.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.server.server.controllers.SensorDataController;
import com.server.server.controllers.SensorDataControllerTest;
import com.server.server.model.Ship;
import com.server.server.repository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SensorValueTest {

    @Mock
    private SensorDataController repo;

    @Mock
    private ShipRepository shipRepo;

    @InjectMocks
    private SensorDataController controller;

    @Test
    public void testGetSensorValue() {
        String group = "group1";
        String sensorName = "sensor1";
        String ship = "ship1";
        List<String> expectedValues = Arrays.asList("value1", "value2", "value3");
        Ship shipObject = new Ship();
        when(shipRepo.getById(ship)).thenReturn(shipObject);
        when(repo.getSensorValue(group, sensorName, String.valueOf(shipObject))).thenReturn(expectedValues);
        List<String> actualValues = controller.getSensorValue(group, sensorName, ship);
        assertEquals(expectedValues, actualValues);
    }
}