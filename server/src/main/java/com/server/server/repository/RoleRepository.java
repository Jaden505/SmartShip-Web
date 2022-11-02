package com.server.server.repository;

<<<<<<< HEAD
// import com.server.server.model.ERole;
import com.server.server.model.Role;
=======
import com.server.server.entity.ERole;
import com.server.server.entity.Role;
>>>>>>> d6646bb1be44ed2f090849708cf8f226f20e617a
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Optional<Role> findByName(ERole name);
}