package com.server.server.controllers;

import com.server.server.controllers.LoginController;

import com.server.server.model.User;
import com.server.server.payload.response.MessageResponse;
import com.server.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/test")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getUsers(){
        try{
            List<User> allUsers = userRepo.findAll();

            if (allUsers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(allUsers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/role/{roleID}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable int roleID){
        try{
            List<User> users = userRepo.findByRoleID(roleID);

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
        try{
            Optional<User> findUser = userRepo.findById(id);

            if (findUser.isPresent()){
                User foundUser = findUser.get();

                foundUser.setEmail(user.getEmail());
                foundUser.setPassword(user.getPassword());
                foundUser.setUsername(user.getUsername());
                foundUser.setShipID(user.getShipID());

                return new ResponseEntity<>(userRepo.save(foundUser), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id){
        try{
            userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
