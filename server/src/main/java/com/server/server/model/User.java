package com.server.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;

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

   private String firstname;

   private String lastname;

   private String gender;

   private String nationality;

   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date dateofbirth;

   private String phonenumber;

   private String address;

   private String postalcode;

   private String city;

   private String country;

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

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getNationality() {
      return nationality;
   }

   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   public Date getDateofbirth() {
      return dateofbirth;
   }

   public void setDateofbirth(Date dateofbirth) {
      this.dateofbirth = dateofbirth;
   }

   public String getPhonenumber() {
      return phonenumber;
   }

   public void setPhonenumber(String phonenumber) {
      this.phonenumber = phonenumber;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPostalcode() {
      return postalcode;
   }

   public void setPostalcode(String postalcode) {
      this.postalcode = postalcode;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }
}
