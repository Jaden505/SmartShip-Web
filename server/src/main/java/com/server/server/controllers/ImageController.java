package com.server.server.controllers;

import com.server.server.model.User;
import com.server.server.repository.UserRepository;
import com.server.server.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private StorageService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("userEmail") String userEmail) throws IOException {
        User user = userRepository.findUserByEmail(userEmail);

        System.out.println(user.getId());

        System.out.println(file);

        String uploadImage = service.uploadImage(file, user);
        byte[] imageData = service.downloadImage(user.getId());

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> downloadImage(@PathVariable int userId){
        byte[] imageData = service.downloadImage(userId);

        if (imageData == null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(null);
        }

        String encImg = Base64.getEncoder().encodeToString(imageData);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(encImg);
    }

}
