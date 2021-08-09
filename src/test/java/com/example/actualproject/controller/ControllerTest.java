package com.example.actualproject.controller;

import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.service.PersonService;
import com.example.actualproject.service.PersonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @Mock
    PersonServiceImpl personService;

    @InjectMocks
    Controller controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void addPersonValid() throws Exception {
        Person p = new Person();
        p.setName("asda");
        p.setAge(12);

        given(personService.create(any(Person.class))).willReturn(p);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(p );

        MvcResult result = mockMvc.perform(post("/person")
                     .contentType(MediaType.APPLICATION_JSON_UTF8)
                     .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("asda"))
        .andReturn();

        then(personService).should().create(any(Person.class));

    }


/*
    @Test
    void addPersonInValid() throws Exception {
        Person p = new Person();
       // p.setName("hi");
        p.setAge(12);

        given(personService.create(any(Person.class))).willReturn(p);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(p);

        mockMvc.perform(post("/person")
                     .contentType(MediaType.APPLICATION_JSON_UTF8)
                     .content(requestJson))
                .andExpect(status().isBadRequest())
                .andExpect(model().attributeHasErrors("e"))
                .andExpect(model().attributeHasFieldErrors("e","name"));

        then(personService).should().create(any(Person.class));

    }
*/


    @Test
    void findAll() throws  Exception {

        given(personService.get(anyInt() ,anyInt())).willReturn(Lists.newArrayList(new PersonAdressDTO(),new PersonAdressDTO()));


        mockMvc.perform(get("/person")
                .param("page","0")
                 .param("size","1"))
                     .andExpect(status().isOk());
    }

    @Test
    void findPersonById() throws Exception{

        PersonAdressDTO p = new PersonAdressDTO();
        p.setPersonName("hi");
        given(personService.findPersonById(anyInt())).willReturn(p);

        mockMvc.perform(get("/person/{id}",1))
            .andExpect(status().isOk());

        then(personService).should().findPersonById(anyInt());

    }

    @Test
    void updatePerson() throws Exception {
        Person p = new Person();
        p.setName("new");
        p.setAge(12);

        given(personService.update(any(Person.class),anyInt())).willReturn(p);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(p);

        mockMvc.perform(put("/person/{pid}",1)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson))
        .andExpect(status().isOk());
    }

    @Test
    void deletePerson() throws Exception{

        mockMvc.perform(delete("/person/{id}",1))
             .andExpect(status().isOk())


        ;
    }
}