package com.server.server.herkansing_controller;

import com.server.server.herkansing_model.Room;
import com.server.server.herkansing_repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable long id) {
        Room room = roomRepository.findById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        Room savedRoom = roomRepository.save(room);

        return ResponseEntity.ok(savedRoom);
    }
}
