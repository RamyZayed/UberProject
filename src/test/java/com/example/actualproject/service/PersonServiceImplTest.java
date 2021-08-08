package com.example.actualproject.service;

import com.example.actualproject.entity.Customer;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    PersonRepository repo;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void create() {
        //given
        Person p = new Person();
        given(repo.save(any(Person.class))).willReturn(p);

        //when
        Person found = personService.create(p);

        //then
        then(repo).should(times(1)).save(any(Person.class));
        assertNotNull(found);

    }

    @Test
    void update() {
        //given
        Person p = new Person();
        p.setName("hehexD");
        given(repo.findById(anyInt())).willReturn(Optional.of(p));
        //when

        Person updated = personService.update(p,1);

        //then

        then(repo).should().updatename(anyString(),anyInt());
        then(repo).should().findById(anyInt());

    }

    @Test
    void get() {
        //given
        Person p = new Person();
        List<Person> list = new ArrayList<>();
        list.add(p);
        Page<Person> page = new PageImpl<>(list);

        given(repo.findAll(any(Pageable.class))).willReturn(page);

        //when

        List<PersonAdressDTO> result = personService.get(1,2);

        //then

        then(repo).should().findAll(any(Pageable.class));

        assertEquals(1,result.size());

    }

    @Test
    void findPersonById() {
        //given
        Person p = new Person();
        given(repo.findById(anyInt())).willReturn(Optional.of(p));
        //when
        PersonAdressDTO personAdressDTO = personService.findPersonById(anyInt());
        //then

        then(repo).should(times(2)).findById(anyInt());
        assertNotNull(personAdressDTO);
    }

    @Test
    void delete() {
        //given

        //when
        personService.Delete(anyInt());

        //then
        then(repo).should().deleteById(anyInt());
    }
}