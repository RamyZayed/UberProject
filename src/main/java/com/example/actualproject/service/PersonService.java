package com.example.actualproject.service;

import com.example.actualproject.entity.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person);

    Person update(Person person, int id);

    List<Person> get(int page , int size);

    void Delete(int id);

}
