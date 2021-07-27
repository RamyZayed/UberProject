package com.example.actualproject.service;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.PersonAddressMapper;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<PersonAdressDTO> get(int page  , int size) {
        Pageable result= PageRequest.of(page,size);
       return  PersonAddressMapper.Instance.toDtoList(personRepository.findAll(result).toList()) ;
    /*    List<PersonAdressDTO> listoo = new ArrayList<>();
        mylist.forEach(person -> listoo.add(PersonAddressMapper.Instance.toDto(person,person.getAddress())));
        return listoo;*/
    }

    @Override
    public PersonAdressDTO findPersonById(int id) {

        return  PersonAddressMapper.Instance.toDto(personRepository.findById(id).get(),personRepository.findById(id).get().getAddress());
    }

    @Override
    public void Delete(int id) {
        personRepository.deleteById(id);

    }


}
