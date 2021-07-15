package com.example.actualproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;
    private String type;

    @ManyToOne
    @JoinColumn(name="person_id",referencedColumnName = "id")
    private Person person;

    @JsonBackReference(value = "person_number")
    public Person getPerson() {
        return person;
    }
}
