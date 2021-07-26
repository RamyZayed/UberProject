package com.example.actualproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person{
    @NotNull(message = "ranking is a no go")
    private String ranking;
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Car_Employee", joinColumns =  @JoinColumn(name = "employee_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="car_id",referencedColumnName = "id"))
    @JsonManagedReference(value = "car_emloyee")
    private Set<Car> cars ;

    @Override
    public String toString() {
        return "Employee{" +
                "ranking='" + ranking + '\'' +
                ", salary=" + salary +
                '}'+super.toString();
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @JsonBackReference(value = "car_emloyee")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }



}
