package com.example.actualproject.service;


import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public Person getCards(@RequestParam int id){
        return personRepository.findById(id).get();


    }


    @PostMapping(value = "/person")
    public void addingemployee(@RequestBody Employee e){
        personRepository.save(e);
    }


    @PutMapping(value = "/person/{id}")
    public void updateEmployee(@PathVariable("id") int id ,@RequestBody Employee e ){
        personRepository.updatename(e.getName(),id);

    }


    @DeleteMapping(value = "/person")
    public void deletePerson(@RequestParam int id )
    {
        personRepository.deleteById(id);
    }

}