package com.example.actualproject.service;

import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.PersonAdressDTO;

import java.util.List;

public interface PersonService {
    Person create(Person person);

    Person update(Person person, int id);

    List<PersonAdressDTO> get(int page , int size);

    PersonAdressDTO findPersonById(int id);

    void Delete(int id);

}
