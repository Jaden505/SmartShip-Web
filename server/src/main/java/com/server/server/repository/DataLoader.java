package com.server.server.repository;

import com.server.server.model.ERole;
import com.server.server.model.Role;
import com.server.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    @Transactional
    public void run(String... args)  {
        System.out.println("Running CommandLine Startup");
        this.createInitialUsers();

        System.out.println("Injected users: " + this.userRepository.findAll());
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    private void createInitialUsers() {
        // check whether the repo is empty
        List<User> userList = this.userRepository.findAll();
        if (userList.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (int i = 0; i < 10; i++) {
            userList.add(this.userRepository.save(User.createSampleUser(i, encoder.encode("password"))));
            System.out.println(userList.get(i).getUsername());
        }

    }
}

