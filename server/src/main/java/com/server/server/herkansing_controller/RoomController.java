package com.server.server.herkansing_controller;

import com.server.server.herkansing_model.Room;
import com.server.server.herkansing_repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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
        try{
            Room room = roomRepository.findById(id);
            return ResponseEntity.ok(room);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){

        if(room.getRoomName() == null || room.getRoomName().isEmpty()){
            room.setRoomName("No name");
        }

        Room savedRoom = roomRepository.save(room);

        return ResponseEntity.ok(savedRoom);
    }
}
