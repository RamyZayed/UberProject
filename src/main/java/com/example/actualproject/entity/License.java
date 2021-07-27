package com.example.actualproject.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date validFrom;
    @Temporal(TemporalType.DATE)
    private Date validTo;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    @JsonBackReference(value = "license_person")
    public Person getPerson() {
        return person;
    }

}
