package com.example.gestionemployee.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "missions_clients",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Client client;
    private LocalDate date;
    private int tgm;
}
