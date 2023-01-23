package com.server.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServerApplication.class)
public class ServerApplicationTests {

    @Autowired
    ServerApplication application = null;

    @Test
    void contextLoads() {
        assertNotNull(application);
        System.out.println("Application auto-configuration has succeeded");
    }

}
