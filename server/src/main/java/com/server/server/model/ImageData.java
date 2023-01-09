package com.server.server.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "ImageData")
@Builder
public class ImageData {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    @OneToOne(cascade = CascadeType.ALL)
    User user;

    public ImageData() {
    }

    public ImageData(Long id, String name, String type, byte[] imageData, User user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageData = imageData;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
