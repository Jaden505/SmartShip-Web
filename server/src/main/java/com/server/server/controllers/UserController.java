package com.server.server.controllers;

import com.server.server.model.User;
import com.server.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepo;

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

    @PostMapping("/users/role={roleID}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable Integer roleID){
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

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        try{
            User user = userRepo.save(newUser);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/users/id={id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        try{
            Optional<User> findUser = userRepo.findById(id);

            if (findUser.isPresent()){
                User foundUser = findUser.get();

                foundUser.setEmail(user.getEmail());
                foundUser.setPassword(user.getPassword());
                foundUser.setRoleID(user.getRoleID());
                foundUser.setUsername(user.getUsername());
//                foundUser.setShipID(foundUser.getShipID());

                return new ResponseEntity<>(userRepo.save(foundUser), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/id={id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        try{
            userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
