package com.example.gestionemployee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
