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

        try {
            Hotel hotel = hotelRepository.findById(id);
            return ResponseEntity.ok(hotel);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {

        if (hotel.getHotelName() == null || hotel.getHotelName().isEmpty()) {
            hotel.setHotelName("No name");
        }

        if (hotel.getCity() == null || hotel.getCity().isEmpty()) {
            hotel.setCity("No city");
        }
        Hotel savedHotel = hotelRepository.save(hotel);

        return ResponseEntity.ok(savedHotel);
    }
}