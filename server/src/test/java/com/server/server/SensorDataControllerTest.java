package com.server.server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SensorDataControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ServerApplication serverAp = null;


    @Test
    @DisplayName("serverApplication Test")
    public void test(){
        assertNotNull(serverAp);
    }


    @Test
    @DisplayName("infoRequestResponse Test")
    public void infoRequestResponse() {
        String message = this.restTemplate.getForObject("/api/test/sensorData/Motor", String.class);
        assertEquals("""
                ["Engine 1 Temperature","Engine 1 Oil Temperature","Engine 1 Oil Level","Engine 1 RPM"]""", message);
    }

    @Test
    @DisplayName("Http Status Code Test")
    public void infoTest(){
        ResponseEntity<String> response
                = restTemplate.getForEntity("/api/test/sensorData/Motor", String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    @DisplayName("Header Test")
    public void infoTestHeader(){
        HttpHeaders httpHeaders = restTemplate.headForHeaders("/api/test/sensorData/Motor");
        assertTrue(Objects.requireNonNull(httpHeaders.getContentType()).includes(MediaType.APPLICATION_JSON));
    }


}
