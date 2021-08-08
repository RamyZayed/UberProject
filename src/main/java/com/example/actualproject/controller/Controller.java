package com.example.actualproject.controller;

import com.example.actualproject.entity.*;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.entity.dto.PersonAddressMapper;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.PersonRepository;
import com.example.actualproject.service.CustomerService;
import com.example.actualproject.service.EmployeeService;
import com.example.actualproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public List<PersonAdressDTO> findAll(@RequestParam int page, @RequestParam int size){
        return personService.get(page , size);
    }

    @GetMapping(value = "/person/{id}")
    public PersonAdressDTO findPersonById(@PathVariable int id){
        return personService.findPersonById(id);
    }

    @PutMapping(value = "/person/{pid}")
    public Person updatePerson(@PathVariable int pid ,@RequestBody Person e ){
       return personService.update(e,pid);
    }

    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable int id )
    {
        personService.Delete(id);
    }



    @GetMapping(value = "/emp/{id}")
    public EmployeeDto findEmployeeById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @GetMapping(value = "/emp")
    public List<EmployeeDto> findEmployees(@RequestParam("page") int page, @RequestParam("size") int size){
        return employeeService.getAllEmployees(page,size);
    }

    @PostMapping(value = "/emp")
    public Employee createEmployee(@RequestBody @Valid Employee emp){
        employeeService.addEmployee(emp);
        return emp;
    }


    @DeleteMapping(value = "/emp")
    public void deleteEmployee(@RequestParam int id )
    {
        employeeService.deleteEmployeeById(id);
    }








    @GetMapping(value = "/customer")
    public List<Customer> findAllCustomers(@RequestParam("page") int page, @RequestParam("size") int size){
        return customerService.getAllCustomers(page,size);
    }

    @PostMapping(value = "/customer")
    public Customer createCustomer(@RequestBody @Valid Customer c){
        customerService.addCustomer(c);
        return c;
    }

    @GetMapping(value = "/customer/{id}")
    public Customer findCustomerById(@PathVariable int id){
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

    @Autowired
    private  PersonRepository pp ;

    @GetMapping(value = "/dto/{id}")
    @ResponseBody
    public PersonAdressDTO something(@PathVariable int id){

        Optional<Person> p = pp.findById(id);
        if(!p.isPresent())
            return null;
        PersonAdressDTO pDto = PersonAddressMapper.Instance.toDto(p.get(),p.get().getAddress());
        return pDto;
    }
}