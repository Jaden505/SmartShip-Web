package com.server.server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShipControllerTest {

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
        String message = this.restTemplate.getForObject("/api/test/ships/{id}", String.class, "07202515-a483-464c-b704-5671f104044b");

        assertTrue(message.contains("""
                [{"id":"07202515-a483-464c-b704-5671f104044b","name":"Serendipity","status":{"id":1,"status":"IDLE"},"""));
    }

    @Test
    @DisplayName("Http Status Code Test")
    public void infoTest(){
        ResponseEntity<String> response
                = restTemplate.getForEntity("/api/test/ships/{id}", String.class, "07202515-a483-464c-b704-5671f104044b");
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
