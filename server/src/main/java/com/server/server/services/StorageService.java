package com.server.server.services;

import com.server.server.model.ImageData;
import com.server.server.model.User;
import com.server.server.repository.StorageRepository;
import com.server.server.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file, User user) throws IOException {

        ImageData image = storageRepository.findByUser(user);

        ImageData image1 = ImageData.builder()
                .name(file.getOriginalFilename())
                .user(user)
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build();

        if (image != null) {
            image1.setId(image.getId());
        }

        ImageData imageData = storageRepository.save(image1);

        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(int user){
        Optional<ImageData> dbImageData = Optional.ofNullable(storageRepository.findByUserId(user));
        byte[] images =ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
