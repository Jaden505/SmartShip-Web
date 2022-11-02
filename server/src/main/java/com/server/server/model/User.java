//package com.server.server.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity @Data @NoArgsConstructor @AllArgsConstructor
//public class User {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String email;
//    private String password;
//    @ManyToOne
//    private Role role = new Role();
//}
