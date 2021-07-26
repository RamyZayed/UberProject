package com.example.actualproject.controller;

import com.example.actualproject.entity.Customer;
import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.service.CustomerService;
import com.example.actualproject.service.EmployeeService;
import com.example.actualproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PersonService personService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/person")
    public Person addPerson(@Valid @RequestBody Person e){
       return personService.create(e);
    }

    @GetMapping(value = "/person")
    public List<Person> findAll(@RequestParam int page, @RequestParam int size){
        return personService.get(page , size);
    }

    @GetMapping(value = "/person/{id}")
    public Person findPersonById(@PathVariable int id){
        return personService.findPersonById(id);
    }

    @PutMapping(value = "/person")
    public Person updatePerson(@RequestParam int id ,@RequestBody Person e ){
       return personService.update(e,id);
    }

    @DeleteMapping(value = "/person")
    public void deletePerson(@RequestParam int id )
    {
        personService.Delete(id);
    }


    @GetMapping(value = "/emp/{page}/{size}")
    public List<Employee> findEmployees(@PathVariable("page") int page, @PathVariable("size") int size){
        return employeeService.getAllEmployees(page,size);
    }

    @PostMapping(value = "/emp")
    public Employee createEmployee(@RequestBody @Valid Employee emp){
        employeeService.addEmployee(emp);
        return emp;
    }

    @GetMapping(value = "/emp")
    public Employee findEmployeeById(@RequestParam int id){
        return employeeService.findById(id);
    }


    @DeleteMapping(value = "/emp")
    public void deleteEmployee(@RequestParam int id )
    {
        employeeService.deleteEmployeeById(id);
    }








    @GetMapping(value = "/customer/{page}/{size}")
    public List<Customer> findAllCustomers(@PathVariable("page") int page, @PathVariable("size") int size){
        return customerService.getAllCustomers(page,size);
    }

    @PostMapping(value = "/customer")
    public Customer createCustomer(@RequestBody @Valid Customer c){
        customerService.addCustomer(c);
        return c;
    }

    @GetMapping(value = "/customer")
    public Customer findCustomerById(@RequestParam int id){
        return customerService.findById(id);
    }

    @DeleteMapping(value = "/customer")
    public void deleteCustomer(@RequestParam int id )
    {
        customerService.deleteCustomerById(id);
    }

    @PutMapping(value = "/customer")
    public Customer updateCustomer(@RequestParam int id,@RequestBody Customer c){
        return  customerService.updateCustomer(c,id);


    }



}