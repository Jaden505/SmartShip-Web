package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @NotBlank
   @Size(max = 20)
   private String username;

   @NotBlank
   @Size(max = 50)
   @Email
   private String email;

   @NotBlank
   @Size(max = 120)
   private String password;

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "role_id", nullable = true)
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private Role role;

   @JoinColumn(name = "ship_id", nullable = true)
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private Ship ship;


   public User() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public String getPassword() {
      return password;
   }

   public Role getRole() {
      return role;
   }

   public Ship getShip() {
      return ship;
   }

   public void setShip(Ship ship) {
      this.ship = ship;
   }

   public void setRole(Role role) {
      this.role = role;
   }
}
