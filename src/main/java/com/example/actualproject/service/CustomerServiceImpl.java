package com.example.actualproject.service;

import com.example.actualproject.entity.Customer;
import com.example.actualproject.entity.Employee;
import com.example.actualproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers(int page, int size) { ///// fix this
        Pageable result= PageRequest.of(page,size);
        Page<Customer> mylist = customerRepository.findAll(result);
        return mylist.toList();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
    @Override
    public Customer updateCustomer(Customer customer,int id) {
        customerRepository.updatename(customer.getName(), id);
        Optional<Customer> byId = customerRepository.findById(customer.getId());
        if(byId.isPresent())
            return byId.get();
        return null;
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
