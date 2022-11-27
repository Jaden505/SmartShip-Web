package com.server.server.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column
   private int roleID;

   public Role() {

   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getRoleID() {
      return roleID;
   }

   public void setRoleID(int roleID) {
       this.roleID = roleID;
   }
}
