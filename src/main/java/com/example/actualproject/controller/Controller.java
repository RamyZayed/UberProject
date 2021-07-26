package com.example.actualproject.controller;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.service.EmployeeService;
import com.example.actualproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PersonService personService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/person")
    public Person addPerson(@Valid @RequestBody Person e){
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

    @GetMapping(value = "/emp")
    public List<Employee> findEmployees(@RequestParam int page, @RequestParam int size){
        return employeeService.getAllEmployees(page,size);
    }

    @PostMapping(value = "/emp")
    public Employee createEmployee(@RequestBody @Valid Employee emp){
        employeeService.addEmployee(emp);
        return emp;
    }
}