package com.example.gestionemployee.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "consultants")
public class Consultant extends Employee {

    @ManyToMany
    @JoinTable(
            name = "consultants_missions",
            joinColumns = @JoinColumn(name = "consultant_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id"))
    private List<Mission> missions;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
