package com.server.server.herkansing_controller;

import com.server.server.herkansing_model.Hotel;
import com.server.server.herkansing_repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable long id) {
        Hotel hotel = hotelRepository.findById(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = hotelRepository.save(hotel);

        return ResponseEntity.ok(savedHotel);
    }
}
