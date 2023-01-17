package com.server.server.repository;

import com.server.server.model.PasswordResetToken;
import com.server.server.model.SensorData;
import com.server.server.model.Ship;
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
        this.createInitialShips();
        this.createInitialSensorDataAttchedToShip();
        this.createInitialPasswordResetToken();

        System.out.println("Injected users: " + this.userRepository.findAll());
        System.out.println("Injected ships: " + this.shipRepository.findAll());
        System.out.println("Injected sensorData: " + this.sensorDataRepository.findAll());
        System.out.println("Injected sensorData: " + this.passwordTokenRepository.findAll());
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

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
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private ShipRepository shipRepository;

    private void createInitialShips() {
        List<Ship> shipList = this.shipRepository.findAll();
        if (shipList.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (int i = 0; i < 3; i++) {
            shipList.add(this.shipRepository.save(Ship.createSampleShip(i)));
        }

    }


    private void createInitialSensorDataAttchedToShip() {
        List<SensorData> sensorDataList = this.sensorDataRepository.findAll();
        if (sensorDataList.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (Ship ship : this.shipRepository.findAll()) {
            for (int i = 0; i < 5; i++) {
                sensorDataList.add(this.sensorDataRepository.save(SensorData.createSampleSensorData(i, ship)));
            }
        }
    }

    @Autowired
    private PasswordTokenRepository passwordTokenRepository;

    private void createInitialPasswordResetToken() {
        List<PasswordResetToken> passwordResetTokens = this.passwordTokenRepository.findAll();
        if (passwordResetTokens.size() > 0 ) return;
        System.out.println("Configuring some initial books in the repository");

        for (User user : this.userRepository.findAll()) {
            passwordResetTokens.add(this.passwordTokenRepository.save(PasswordResetToken.createSampleSensorData((long) Math.floor(Math.random()*20), user)));
        }
    }
}

