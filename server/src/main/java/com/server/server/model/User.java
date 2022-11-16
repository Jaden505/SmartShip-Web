package com.server.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "email")
   private String email;

   @Column(name = "password")
   private String password;

   @Column(name = "username")
   private String username;

   @Column(name = "role_id")
   private int role_id;

   public User(String email, String password, String username, int role_id) {
      this.email = email;
      this.password = password;
      this.username = username;
      this.role_id = role_id;
   }

   public String getEmail() {
      return email;
   }

   public String getPassword() {
      return password;
   }

   public String getUsername() {
      return username;
   }

   public int getRole_id() {
      return role_id;
   }

   //   @ManyToOne
//   private Role role = new Role();
}
