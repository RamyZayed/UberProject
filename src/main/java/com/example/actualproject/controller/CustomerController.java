package com.example.actualproject.controller;

import com.example.actualproject.aspect.Timer;
import com.example.actualproject.entity.Customer;
import com.example.actualproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Timer
    @GetMapping(value = "/customer")
    public List<Customer> findAllCustomers(@RequestParam("page") int page, @RequestParam("size") int size){
        return customerService.getAllCustomers(page,size);
    }

    @Timer
    @PostMapping(value = "/customer")
    public Customer createCustomer(@RequestBody @Valid Customer c){
        customerService.addCustomer(c);
        return c;
    }

    @Timer
    @GetMapping(value = "/customer/{id}")
    public Customer findCustomerById(@PathVariable int id){
        return customerService.findById(id);
    }

    @Timer
    @DeleteMapping(value = "/customer")
    public void deleteCustomer(@RequestParam int id )
    {
        customerService.deleteCustomerById(id);
    }

    @Timer
    @PutMapping(value = "/customer")
    public Customer updateCustomer(@RequestParam int id,@RequestBody Customer c){
        return  customerService.updateCustomer(c,id);


    }

}
