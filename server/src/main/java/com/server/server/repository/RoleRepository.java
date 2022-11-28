package com.server.server.repository;

import com.server.server.model.ERole;
import com.server.server.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByName(ERole name);

   Role findById(int id);

   Boolean existsByRoleID(int roleID);
}
