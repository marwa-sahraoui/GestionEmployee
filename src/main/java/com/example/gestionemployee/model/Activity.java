package com.example.gestionemployee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int daysOff;
    private int daysOfWork;
}
