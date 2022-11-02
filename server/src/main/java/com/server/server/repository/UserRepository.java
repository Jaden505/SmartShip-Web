package com.server.server.repository;

<<<<<<< HEAD
import com.server.server.model.Role;
import com.server.server.model.User;
=======
import com.server.server.entity.User;
>>>>>>> d6646bb1be44ed2f090849708cf8f226f20e617a
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}