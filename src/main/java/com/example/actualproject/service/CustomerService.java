package com.example.actualproject.service;

import com.example.actualproject.entity.Customer;
import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Trip;

import java.util.List;

public interface CustomerService  {
    List<Customer> getAllCustomers(int page , int size);
    Customer findById(int id );
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer,int id);
    void deleteCustomerById(int id);

    Trip findCustomers(String Customerid);
}
