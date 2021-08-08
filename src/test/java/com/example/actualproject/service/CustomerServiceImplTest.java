package com.example.actualproject.service;

import com.example.actualproject.entity.Customer;
import com.example.actualproject.repository.CustomerRepository;
import org.apache.catalina.util.CustomObjectInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository repo;

    @InjectMocks
    CustomerServiceImpl customerService;




    @Test
    void getAllCustomers() {
        //given
        Customer c = new Customer();
        List<Customer> list = new ArrayList<>();
        list.add(c);

        Page<Customer>  page = new PageImpl<>(list);

        given(repo.findAll(any(Pageable.class))).willReturn(page);

        //when

        List<Customer> found = customerService.getAllCustomers(0,1);

        assertEquals(1,found.size());
    }

    @Test
    void findById() {
        //given
        Customer b = new Customer();
        given(repo.findById(any())).willReturn(Optional.of(b));
        //when
        Customer found = customerService.findById(1);

        //then

        then(repo).should().findById(any());
        assertNotNull(found);

    }

    @Test
    void addCustomer() {
        //given
        Customer c = new Customer();
        given(repo.save(any(Customer.class))).willReturn(c);
        //when
        Customer saved = customerService.addCustomer(new Customer());
        //then
        then(repo).should().save(any(Customer.class));
        assertNotNull(saved);

    }

    @Test
    void updateCustomerIsFound() {
        //given
        Customer p = new Customer();
        given(repo.findById(anyInt())).willReturn(Optional.of(p));

        //when

        Customer update  = customerService.updateCustomer(new Customer(),1);
        //then

        then(repo).should().findById(anyInt());

    }


    @Test
    void updateCustomerIsNotFound() {
        //given
        Customer p = new Customer();


        //when

        Customer update  = customerService.updateCustomer(new Customer(),1);
        //then


        then(repo).should().findById(anyInt());
        assertNull(update);

    }

    @Test
    void deleteCustomerById() {
        //given

        //when
        customerService.deleteCustomerById(1);

        //then

        then(repo).should().deleteById(anyInt());

    }
}