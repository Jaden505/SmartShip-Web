package com.server.server.repositories;

import com.server.server.ServerApplication;
import com.server.server.model.ERole;
import com.server.server.model.Role;
import com.server.server.model.User;
import com.server.server.repository.TestDataLoader;
import com.server.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestDataLoader.class)
public class UserRepositoryTest {

    // Import the DataLoader class to load the data into the database
    @Autowired
    CommandLineRunner dataLoader;

    // Import the UserRepository class to test the methods
    @Autowired
    private UserRepository userRepository;

    // Declare the list of users
    private List<User> users;

    // Before each test, load the data into the database and assign the list of users
    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.users = this.userRepository.findAll();
    }

    @Test
    public void repoFindAllUsers() {
        // check users have been loaded
        assertTrue(this.users.size() > 0);
    }

    @Test
    public void repoFindUserByUsername() {
        // check all users can be found by its username
        for (User value : this.users) {
            Optional<User> user = userRepository.findByUsername(value.getUsername());
            assertEquals(value.getEmail(), user.get().getEmail());
        }

        // check non-existing user cannot be found
        Optional<User> user = userRepository.findByUsername("non-existing");
        assertFalse(user.isPresent());
    }

    @Test
    public void repoSaveAndUpdateUser() {
        // add new user and save it to the database
        User user = new User(0, "noah", "noah@gmail.com", "noah", new Role(ERole.ROLE_ADMIN), null, "Noah", "B", "male", null, null, null, null, null, null, null);
        User savedUser = userRepository.save(user);
        // check id generation
        assertTrue(savedUser.getId() > 0);

        // find added user by its username
        Optional<User> newUser = userRepository.findByUsername(savedUser.getUsername());
        assertEquals(newUser.get().getUsername(), savedUser.getUsername());
        assertEquals(newUser.get().getEmail(), savedUser.getEmail());
        assertEquals(newUser.get().getGender(), savedUser.getGender());

        // change user's city and update the database
        savedUser.setCity("Andijk");
        User updatedUser = userRepository.save(savedUser);

        // check persistence of change
        assertEquals(updatedUser.getCity(), savedUser.getCity());
    }
}
