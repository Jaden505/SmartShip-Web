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
public class SensorDataControllerTest {

    @Mock
    private SensorDataRepository repo;

    @InjectMocks
    private SensorDataController controller;

    @Test
    public void testGetCategories_returnsExpectedCategories() {
        // Arrange
        List<String> expectedCategories = Arrays.asList("category1", "category2", "category3");
        when(repo.getCategories()).thenReturn(expectedCategories);

        // Act
        List<String> actualCategories = controller.getCategories();

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void testGetCategories_returnsEmptyList() {
        // Arrange
        List<String> expectedCategories = new ArrayList<>();
        when(repo.getCategories()).thenReturn(expectedCategories);

        // Act
        List<String> actualCategories = controller.getCategories();

        // Assert
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void testGetCategories_returnsNull() {
        // Arrange
        when(repo.getCategories()).thenReturn(null);

        // Act
        List<String> actualCategories = controller.getCategories();

        // Assert
        assertEquals(null, actualCategories);
    }
}