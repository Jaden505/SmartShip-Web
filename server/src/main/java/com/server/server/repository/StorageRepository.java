package com.server.server.repository;

import com.server.server.model.ImageData;
import com.server.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {

    ImageData findByUser(User user);

    ImageData findByUserId(int user);

    Optional<ImageData> findByName(String fileName);
}
