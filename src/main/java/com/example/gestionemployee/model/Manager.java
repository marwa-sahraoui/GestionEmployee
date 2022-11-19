package com.example.gestionemployee.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager extends Employee {
}
