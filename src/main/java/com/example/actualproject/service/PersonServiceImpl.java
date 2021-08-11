package com.example.actualproject.service;

import com.example.actualproject.entity.Address;
import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.PersonAddressMapper;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

   // Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person create( Person person) {
      //  logger.trace("created a person is accessed" +person.toString());
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person , int id) {
         personRepository.updatename(person.getName(),id);
       // logger.trace("trying update Person with id : " +id +"    With Values :"  +person.toString() );
         return personRepository.findById(id).get();
    }


    @Override
    public List<PersonAdressDTO> get(int page  , int size) {
        //logger.info("accesing the service of getting all the people with page number of:"+page +"and page size of :"+size);
        Pageable result= PageRequest.of(page,size);
        List<Address> addresses =new ArrayList<>();
        return  PersonAddressMapper.Instance.toDtoList(personRepository.findAll(result).toList() ) ;
    }

    @Override
    public PersonAdressDTO findPersonById(int id) {
      //  logger.trace("Trying to find Person with id = " +id);
        return  PersonAddressMapper.Instance.toDto(personRepository.findById(id).get(),personRepository.findById(id).get().getAddress());
    }

    @Override
    public void Delete(int id) {
       // logger.trace("Trying to delete person with id=" +id);
        personRepository.deleteById(id);

    }


}
