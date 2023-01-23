package com.server.server.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.server.server.repository.SensorDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SensorNameTest {

    @Mock
    private SensorDataRepository repo;

    @InjectMocks
    private SensorDataController controller;

    @Test
    public void testGetSensorName_returnsExpectedSensorNames() {
        // Arrange
        String group = "group1";
        List<String> expectedSensorNames = Arrays.asList("sensor1", "sensor2", "sensor3");
        when(repo.getSensorName(group)).thenReturn(expectedSensorNames);

        // Act
        List<String> actualSensorNames = controller.getSensorName(group);

        // Assert
        assertEquals(expectedSensorNames, actualSensorNames);
    }

    @Test
    public void testGetSensorName_returnsEmptyList() {
        // Arrange
        String group = "group1";
        List<String> expectedSensorNames = new ArrayList<>();
        when(repo.getSensorName(group)).thenReturn(expectedSensorNames);

        // Act
        List<String> actualSensorNames = controller.getSensorName(group);

        // Assert
        assertEquals(expectedSensorNames, actualSensorNames);
    }

    @Test
    public void testGetSensorName_returnsNull() {
        // Arrange
        String group = "group1";
        when(repo.getSensorName(group)).thenReturn(null);

        // Act
        List<String> actualSensorNames = controller.getSensorName(group);

        // Assert
        assertEquals(null, actualSensorNames);
    }
}