package com.example.actualproject.service;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person , int id) {
         personRepository.updatename(person.getName(),id);
         return personRepository.findById(id).get();
    }


    @Override
    public List<Person> get(int page  , int size) {
        Pageable result= PageRequest.of(page,size);
        Page<Person> mylist = personRepository.findAll(result);
        return mylist.toList();
    }

    @Override
    public void Delete(int id) {
        personRepository.deleteById(id);

    }


}
