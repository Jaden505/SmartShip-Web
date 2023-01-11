package com.server.server.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDate expiryDate;

    public PasswordResetToken(String token, User user, LocalDate expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public PasswordResetToken() {

    }

    public User getUser() {
        return user;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getToken() {
        return token;
    }
}
