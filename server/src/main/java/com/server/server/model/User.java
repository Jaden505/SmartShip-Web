package com.server.server.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(	name = "user_role",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "roleID"))
   private Set<Role> roles = new HashSet<>();

   @Column(name = "roleID")
   private int roleID;

   @Column(name = "shipID")
   private int shipID;

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

   public String getEmail() {
      return email;
   }

   public String getPassword() {
      return password;
   }

   public Set<Role> getRoles() {
      return roles;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }
}
