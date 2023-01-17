package com.server.server.repositories;

import com.server.server.model.ERole;
import com.server.server.model.Role;
import com.server.server.model.User;
import com.server.server.repository.DataLoader;
import com.server.server.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
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
@Import(DataLoader.class)
public class UserRepositoryTest {

    @Autowired
    CommandLineRunner dataLoader;

    @Autowired
    private UserRepository userRepository;

    private List<User> users;

    @BeforeAll
    public static void classLevelSetup() {
        System.out.println("initialise static values and expensive data structures");
    }

    @BeforeEach
    public void setup() throws Exception {
        this.dataLoader.run(null);
        this.users = this.userRepository.findAll();
    }

    @Test
    public void repoFindAllUsers() {
        // check books have been loaded
        assertTrue(this.users.size() > 0);
    }

    @Test
    public void repoFindUserByUsername() {
        // check all users can be found by id
        for (User value : this.users) {
            Optional<User> user = userRepository.findByUsername(value.getUsername());
            assertEquals(value.getEmail(), user.get().getEmail());
        }

        // check non-existing book
        Optional<User> book = userRepository.findByUsername("non-existing");
        assertFalse(book.isPresent());
    }

    @Test
    public void repoSaveAndUpdateUser() {
        // add some book
        User user = new User(0, "noah", "noah@gmail.com", "noah", new Role(ERole.ROLE_ADMIN), null, "Noah", "B", "male", null, null, null, null, null, null, null);
        User savedUser = userRepository.save(user);
        // check id generation
        assertTrue(savedUser.getId() > 0);

        // find added book
        Optional<User> newUser = userRepository.findByUsername(savedUser.getUsername());
        assertEquals(newUser.get().getUsername(), savedUser.getUsername());
        assertEquals(newUser.get().getEmail(), savedUser.getEmail());
        assertEquals(newUser.get().getGender(), savedUser.getGender());

        // change the book
        savedUser.setCity("Andijk");
        User updatedUser = userRepository.save(savedUser);

        // check persistence of change
        assertEquals(updatedUser.getCity(), savedUser.getCity());
    }



}
