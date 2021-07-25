package com.example.actualproject.controller;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private PersonService personService;




    @PostMapping(value = "/person")
    public Person addingemployee(@Valid @RequestBody Employee e){
       return personService.create(e);
    }

    @GetMapping(value = "/person")
    public List<Person> findAll(@RequestParam int page, @RequestParam int size){
        return personService.get(page , size);
    }

    @PutMapping(value = "/person/{id}")
    public Person updatePerson(@PathVariable("id") int id ,@RequestBody Person e ){
       return personService.update(e,id);

    }

    @DeleteMapping(value = "/person")
    public void deletePerson(@RequestParam int id )
    {
        personService.Delete(id);
    }

}
