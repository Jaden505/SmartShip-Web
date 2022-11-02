package com.server.server.controllers;

import com.server.server.model.Ship;

import com.server.server.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api")
public class ShipController {
    @Autowired
    private ShipRepository shipRepo;

    @GetMapping("/ships")
    public ResponseEntity<List<Ship>> getShips() {
        try {
            List<Ship> ships = new ArrayList<>(shipRepo.findAll());

            if (ships.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ships, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
