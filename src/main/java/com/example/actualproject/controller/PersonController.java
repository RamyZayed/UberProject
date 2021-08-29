package com.example.actualproject.controller;

import com.example.actualproject.aspect.Timer;
import com.example.actualproject.entity.*;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.service.CustomerService;
import com.example.actualproject.service.EmployeeService;
import com.example.actualproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


        // hasRole('ROLE_')   hasAnyRole('ROLE_')   hasAuthority('permission') hasAnyAuthority('permission)

    @Timer
 //   @PreAuthorize("hasAuthority('person:write')")
    @PostMapping(value = "/person")
    public Person addPerson(@Valid  @RequestBody  Person e, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            System.out.println("Error in INput");
       return personService.create(e);
    }

    @Timer
  //  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    @GetMapping(value = "/person")
    public List<PersonAdressDTO> findAll(@RequestParam int page, @RequestParam int size){
        return personService.get(page , size);
    }

    @Timer
   // @PreAuthorize("hasAuthority('person:read')")
    @GetMapping(value = "/person/{id}")
    public PersonAdressDTO findPersonById(@PathVariable int id){
        return personService.findPersonById(id);
    }

    @Timer
  //  @PreAuthorize("hasAuthority('person:write')")
    @PutMapping(value = "/person/{pid}")
    public Person updatePerson(@PathVariable int pid ,@RequestBody Person e ){
       return personService.update(e,pid);
    }

    @Timer
    //@PreAuthorize("hasAuthority('person:write')")
    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable int id )
    {
        personService.Delete(id);
    }








   /* @Autowired
    private  PersonRepository pp ;

    @Timer
    @GetMapping(value = "/dto/{id}")
    @ResponseBody
    public PersonAdressDTO something(@PathVariable int id){

        Optional<Person> p = pp.findById(id);
        if(!p.isPresent())
            return null;
        PersonAdressDTO pDto = PersonAddressMapper.Instance.toDto(p.get(),p.get().getAddress());
        return pDto;
    }*/
}