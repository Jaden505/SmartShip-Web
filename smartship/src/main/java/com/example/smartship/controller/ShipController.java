package com.example.smartship.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ships")
public class ShipController {

    /**
     * show all ships
     * @return
     */
    @GetMapping("")
    public List<Object> getAllShips() {
        return null;
    }

    /**
     * creating new ship
     * @param ship
     */
    @PostMapping()
    public void createShip(@RequestBody Object ship) {

    }

    /**
     * Changing by id
     * @param id
     * @param ship
     */
    @PutMapping("{id}")
    public void updateShip(@PathVariable long id, @RequestBody Object ship){

    }

    /**
     * deleting by id
     * @param id
     */
    @DeleteMapping("{id}")
    public void deleteScooter(@PathVariable long id){

    }
}
