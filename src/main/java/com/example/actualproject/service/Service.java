package com.example.actualproject.service;


import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Service {

    @Autowired
    PersonRepository personRepository;


/*
  @GetMapping(value = "/person")
    public Person gettingPeople(@RequestParam int id){
        List<Person> allPeople = new ArrayList<>();
        personRepository.findAll().forEach(allPeople::add);
        return personRepository.findById(id).get();
    }

*/
    @GetMapping(value = "/person")
    public List<Object[] >getCards(@RequestParam int id){
        List<Object[]>  cars = personRepository.findcars(id);
        return cars;

    }


    @PostMapping(value = "/person")
    public void addingemployee(@RequestBody Employee e){
        personRepository.save(e);
    }

    @PatchMapping(value = "/person")
    public void updateEmployee(){
    }

}
