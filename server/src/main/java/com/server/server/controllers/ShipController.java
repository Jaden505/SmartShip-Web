package com.server.server.controllers;

import com.server.server.model.Ship;
import com.server.server.repository.ShipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShipController {
    @Autowired
    private ShipRepository shipRepo;

    // todo eventually this can be deleted for now use /test
    @GetMapping("/test/chart")
    public List<Ship> getWater(){
        return shipRepo.findAll();
    }

    // todo this doesn't get used for testing
    @GetMapping("/test/chart/{id}")
    public Optional<Ship> getById(@PathVariable int id){
        Optional<Ship> ship = shipRepo.findById(id);
        if(ship.isPresent()){
            return ship;
        }
        return null;
    }
    @GetMapping("/ships")
    public List<Ship> getShips(){
        return shipRepo.findAll();
    }
}
