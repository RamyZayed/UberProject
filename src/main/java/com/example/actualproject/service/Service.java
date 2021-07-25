package com.example.actualproject.service;


import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.repository.EmployeeRepository;
import com.example.actualproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class Service {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EmployeeRepository employeeRepository;


/*
  @GetMapping(value = "/person")
    public Person gettingPeople(@RequestParam int id){
        List<Person> allPeople = new ArrayList<>();
        personRepository.findAll().forEach(allPeople::add);
        return personRepository.findById(id).get();
    }

*/
    // done
    @GetMapping(value = "/person")
    public List<Person> getCards(@RequestParam int page, @RequestParam int size){
        Pageable result= PageRequest.of(page,size);
        Page<Person> mylist = personRepository.findAll(result);
        return mylist.toList();

    }


    @PostMapping(value = "/person")
    public Employee addingemployee(@Valid @RequestBody Employee e){
        personRepository.save(e);
        return e;
    }


    @PutMapping(value = "/person/{id}")
    public void updateEmployee(@PathVariable("id") int id ,@RequestBody Employee e ){
        personRepository.updatename(e.getName(),id);

    }


    @DeleteMapping(value = "/person")
    public void deletePerson(@RequestParam int id )
    {
        employeeRepository.deleteById(id);
    }

}