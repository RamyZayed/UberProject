package com.example.actualproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "license_number")
    private int licenseNumber;
    private String type;
    private String color;

    @ManyToMany(mappedBy = "cars")
    @JsonBackReference(value = "work")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }
}
