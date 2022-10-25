package com.server.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String location;
    private String status;
    private String origin;
    private String destination;
}
