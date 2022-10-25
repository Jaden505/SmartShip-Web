package com.server.server.controller;

import com.server.server.entity.Ship;
import com.server.server.repository.ShipRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class ShipController {
    @Autowired
    private ShipRepo shipRepo;

    @GetMapping("/ships")
    public List<Ship> getShips(){
        return shipRepo.findAll();
    }
}
