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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
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
    void addPerson() throws Exception {

        given(personService.create(any(Person.class))).willReturn(new Person());

        Person p = new Person();
        p.setName("asda");
        p.setAge(12);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(p );

        mockMvc.perform(post("/person")

                     .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(requestJson))
                .andExpect(status().isOk());
    }

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

        mockMvc.perform(get("/person/{id}",1))
            .andExpect(status().isOk());

    }

    @Test
    void updatePerson() throws Exception {

        mockMvc.perform(put("/person/{pid}",1)
                .param("name","hehe")
                .param("age","15"))
        .andExpect(status().isOk());
    }

    @Test
    void deletePerson() {
    }
}