package com.server.server.controllers;

import com.server.server.model.Ship;
import com.server.server.model.User;
import com.server.server.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/ships/all")
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

    @GetMapping("/ships/{id}")
    public ResponseEntity<List<Ship>> getSpecificShip(@PathVariable String id) {
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

        newShip.setId(ship_details.getId());
        newShip.setName(ship_details.getName());
        newShip.setGpsLongtitude(ship_details.getGpsLongtitude());
        newShip.setGpsLatitude(ship_details.getGpsLatitude());
        newShip.setStatus(ship_details.getStatus());
        newShip.setTank1(ship_details.getTank1());
        newShip.setTank2(ship_details.getTank2());

        try {
            Ship ship = shipRepo.save(newShip);
            return new ResponseEntity<>(ship, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/ships/{id}")
    public ResponseEntity<Ship> updateShip(@PathVariable String id, @RequestBody Ship ship) {
        try {
            List<Ship> findShip = shipRepo.findShipById(id);
            Ship foundShip = findShip.get(0);

            foundShip.setName(ship.getName());
            foundShip.setGpsLongtitude(ship.getGpsLongtitude());
            foundShip.setGpsLatitude(ship.getGpsLatitude());
            foundShip.setStatus(ship.getStatus());

            return new ResponseEntity<>(shipRepo.save(foundShip), HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ships/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        try {
            shipRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ships/{id}/watersupply")
    public ResponseEntity<List<Integer>> getWaterSupply(@PathVariable String id) {
        try {
            List<Ship> ships = new ArrayList<>(shipRepo.findShipById(id));

            if (ships.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<Integer> waterTanks = Arrays.asList(ships.get(0).getTank1(), ships.get(0).getTank2());
            return new ResponseEntity<>(waterTanks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
