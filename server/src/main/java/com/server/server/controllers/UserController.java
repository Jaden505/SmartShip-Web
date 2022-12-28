package com.server.server.controllers;

import com.server.server.model.Ship;
import com.server.server.model.User;
import com.server.server.repository.UserRepositoryJPA;
import com.server.server.repository.ShipRepository;
import com.server.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/test")
public class UserController {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getUsers(){
        try{
            List<User> allUsers = userRepositoryJPA.findAll();
            System.out.println(allUsers);

            return new ResponseEntity<>(allUsers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/role/{role}")
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role){
        try{
            List<User> users = userRepositoryJPA.findByRole(role);

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
            Optional<User> findUser = userRepository.findById(id);

            if (findUser.isPresent()){
                User foundUser = findUser.get();

                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
                foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

                foundUser.setEmail(user.getEmail());
                foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                foundUser.setUsername(user.getUsername());

                if (user.getShip() == null){
                    foundUser.setShip(null);
                } else {
                    List<Ship> ship = shipRepository.findShipById(user.getShip().getId());
                    foundUser.setShip(ship.get(0));
                }

                return new ResponseEntity<>(userRepository.save(foundUser), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id){
        try{
            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()){
                user.get().setRole(null);
                user.get().setShip(null);
            }

            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
