package com.server.server.controllers;

import com.server.server.model.User;
import com.server.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        try{
            List<User> allUsers = new ArrayList<>(userRepo.findAll());
            List<User> operators = new ArrayList<>();

            if (allUsers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            for (User user : allUsers) {
                int userId = 1;

                if (user.getRole_id() == userId) {
                    operators.add(user);
                }

            }

            return new ResponseEntity<>(operators, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
