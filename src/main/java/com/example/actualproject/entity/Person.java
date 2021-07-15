package com.example.actualproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Embedded
    private Address address;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private License license;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    @JsonBackReference(value = "license_person")
    public License getLicense() {
        return license;
    }
    @JsonBackReference(value = "person_number")
    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber){
        if(phoneNumber != null){
            if(numbers==null){
                numbers = new HashSet<>();

            }
            phoneNumber.setPerson(this);
            numbers.add(phoneNumber);

        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}