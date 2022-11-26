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
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/test")
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
    public ResponseEntity<List<Ship>> getSpecificShip(@PathVariable int id) {
        try {
            List<Ship> ship = shipRepo.findShipById(id);

            if (ship.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ship, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ships/create")
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship_details) {
        Ship newShip = new Ship();

        newShip.setName(ship_details.getName());
        newShip.setGpsLongtitude(ship_details.getGpsLongtitude());
        newShip.setGpsLatitude(ship_details.getGpsLatitude());
        newShip.setStatus(ship_details.getStatus());
        newShip.setLocation(ship_details.getLocation());
        newShip.setRpm(0);
        newShip.setkW(0);
        newShip.setWaterTank1(1);
        newShip.setWaterTank1(2);

        try {
            Ship ship = shipRepo.save(newShip);
            return new ResponseEntity<>(ship, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/ships/shipId={id}")
    public ResponseEntity<Ship> updateShip(@PathVariable int id, @RequestBody Ship ship) {
        try {
            List<Ship> findShip = shipRepo.findShipById(id);
            Ship foundShip = findShip.get(0);

            foundShip.setName(ship.getName());
            foundShip.setGpsLongtitude(ship.getGpsLongtitude());
            foundShip.setGpsLatitude(ship.getGpsLatitude());
            foundShip.setOrigin(ship.getName());
            foundShip.setDestination(ship.getDestination());
            foundShip.setRpm(0);
            foundShip.setkW(0);
            foundShip.setWaterTank1(1);
            foundShip.setWaterTank1(2);

            return new ResponseEntity<>(shipRepo.save(foundShip), HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ships/shipId={id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        try {
            shipRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo eventually this can be deleted for now use /test
    @GetMapping("/test/chart")
    public List<Ship> getWater() {
        return shipRepo.findAll();
    }

    // todo this doesn't get used for testing
    @GetMapping("/test/chart/{id}")
    public Optional<Ship> getById(@PathVariable int id) {
        Optional<Ship> ship = shipRepo.findById(id);
        if (ship.isPresent()) {
            return ship;
        }
        return null;
    }

}
