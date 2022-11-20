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

   @Column(name = "roleID")
   private int roleID;

   @Column(name = "shipID")
   private int shipID;

   public String getEmail() {
      return email;
   }

   public String getPassword() {
      return password;
   }

   public String getUsername() {
      return username;
   }

   public int getRoleID() {
      return roleID;
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

   public void setRoleID(int roleID) {
      this.roleID = roleID;
   }

   public int getShipID() {
      return shipID;
   }

   public void setShipID(int shipID) {
      this.shipID = shipID;
   }
}
