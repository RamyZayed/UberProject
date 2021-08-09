package com.example.actualproject.entity;

import com.example.actualproject.PersonView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@SqlResultSetMapping(
        name="findingstuff",
                columns = {
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "age",type = Integer.class)
                }


)


@NamedNativeQuery(name ="fedro",
        resultClass = PersonView.class,
        resultSetMapping = "findingstuff",
        query = "select p.name , p.age from person p where p.name =:name "

)


@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "this is a nono")
    private String name;
    private int age;
    @Embedded
    private Address address;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference(value = "license_person")
    private License license;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference(value = "person_number")
    private Set<PhoneNumber> numbers;


    public License getLicense() {
        return license;
    }

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
