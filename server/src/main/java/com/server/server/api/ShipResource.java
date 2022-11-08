package com.server.server.api;

import com.server.server.entity.Ship;
import com.server.server.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class ShipResource {
    private final ShipService shipService;

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> getUsers() {
        return ResponseEntity.ok().body(shipService.getShips());
    }
}
