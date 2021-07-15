package com.example.actualproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends Person {
}
