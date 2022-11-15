package com.server.server.controllers;

import com.server.server.model.Ship;
import com.server.server.repository.ShipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShipController {
    @Autowired
    private ShipRepository shipRepo;

    //Dit heb ik (Vincent) gebruikt, omdat ik met de endpoint 'test' alleen maar dingen kan
    // ophalen de rest heb ik geen autenthication voor
    @GetMapping("/test/chart")
    public List<Ship> getWaterTank(){
        return shipRepo.findAll();
    }
    @GetMapping("/ships")
    public List<Ship> getShips(){
        return shipRepo.findAll();
    }
}
