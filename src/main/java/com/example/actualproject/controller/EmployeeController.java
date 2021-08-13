package com.example.actualproject.controller;

import com.example.actualproject.aspect.Timer;
import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Timer
    @GetMapping(value = "/emp/{id}")
    public EmployeeDto findEmployeeById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @Timer
    @GetMapping(value = "/emp")
    public List<EmployeeDto> findEmployees(@RequestParam("page") int page, @RequestParam("size") int size){
        return employeeService.getAllEmployees(page,size);
    }

    @Timer
    @PostMapping(value = "/emp")
    public Employee createEmployee(@RequestBody @Valid Employee emp){
        employeeService.addEmployee(emp);
        return emp;
    }


    @Timer
    @DeleteMapping(value = "/emp")
    public void deleteEmployee(@RequestParam int id )
    {
        employeeService.deleteEmployeeById(id);
    }


}
