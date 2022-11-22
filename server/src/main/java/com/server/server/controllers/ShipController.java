package com.server.server.controllers;

import com.server.server.model.Ship;

import com.server.server.model.User;
import com.server.server.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ships/shipId={id}")
    public ResponseEntity<List<Ship>> getSpecificShip(@PathVariable int id){
        try{
            List<Ship> ship = shipRepo.findShipById(id);

            if (ship.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ship, HttpStatus.OK);

         } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/ships/shipId={id}")
    public ResponseEntity<Ship> updateShip(@PathVariable int id, @RequestBody Ship ship){
        try{
            List<Ship> findShip = shipRepo.findShipById(id);
            Ship foundShip = findShip.get(0);

            foundShip.setName(ship.getName());
            foundShip.setLocation(ship.getLocation());
            foundShip.setOrigin(ship.getName());
            foundShip.setDestination(ship.getDestination());

            return new ResponseEntity<>(shipRepo.save(foundShip), HttpStatus.OK);
            

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
