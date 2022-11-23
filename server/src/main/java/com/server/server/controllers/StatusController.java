package com.server.server.controllers;

import com.server.server.model.Status;
import com.server.server.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping("/api")
public class StatusController {
    @Autowired
    private StatusRepository statusRepo;

    @GetMapping("/statuses")
    public ResponseEntity<List<Status>> getStatuses(){
        try{
            List<Status> statuses = statusRepo.findAll();

            if (statuses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(statuses, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
