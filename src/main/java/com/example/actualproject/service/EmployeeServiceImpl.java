package com.example.actualproject.service;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.entity.dto.EmployeeDtoMapper;
import com.example.actualproject.entity.dto.PersonAddressMapper;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.EmployeeRepository;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl  implements EmployeeService{

   // private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees(int page, int size){

      //  logger.error("Trying to find all employees with page = "+page +"and size = "+size);
        Pageable result= PageRequest.of(page,size);
        return EmployeeDtoMapper.Instance.toDtoList(employeeRepository.findAll(result).toList());


       // List<EmployeeDto> listoo = new ArrayList<>();
      //  mylist.forEach(emp -> listoo.add(EmployeeDtoMapper.Instance.toDto(emp)));
      //  return listoo;

    }

    @Override
    public EmployeeDto findById(int id) {
      //  logger.trace("trying to find person with id = "+id);
        EmployeeDto someone = EmployeeDtoMapper.Instance.toDto(employeeRepository.findById(id).get());
        return someone;
    }


    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
      //  logger.trace("trying to add new employee: "+employee.toString());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        //logger.trace("trying to update  employee: "+employee.toString());
        employeeRepository.updatename(employee.getName(), employee.getId());
        return employeeRepository.findById(employee.getId()).get();
    }

    @Override
    public void deleteEmployeeById(int id) {
       // logger.trace("trying to delete an employee with id: "+id);
        employeeRepository.deleteById(id);

    }

}
