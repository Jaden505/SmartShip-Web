package com.server.server.repository;

import com.server.server.model.Ship;
import com.server.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TestDataLoader implements CommandLineRunner {

    @Override
    @Transactional
    public void run(String... args)  {
        System.out.println("Running CommandLine Startup");
        this.createInitialUsers();
        this.createInitialShips();

        System.out.println("Injected users: " + this.userRepository.findAll());
        System.out.println("Injected ships: " + this.shipRepository.findAll());
    }

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private void createInitialUsers() {
        List<User> userList = this.userRepository.findAll();
        if (userList.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (int i = 0; i < 10; i++) {
            userList.add(this.userRepository.save(User.createSampleUser(i, encoder.encode("password"))));
            System.out.println(userList.get(i).getUsername());
        }

    }

    @Autowired
    private ShipRepository shipRepository;

    private void createInitialShips() {
        List<Ship> shipList = this.shipRepository.findAll();
        if (shipList.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (int i = 0; i < 5; i++) {
            shipList.add(this.shipRepository.save(Ship.createSampleShip(i)));
        }

    }
}
