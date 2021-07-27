package com.example.actualproject.entity.dto;

import com.example.actualproject.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.actualproject.entity.Person;

import java.util.List;

@Mapper
public interface EmployeeDtoMapper {

    EmployeeDtoMapper Instance = Mappers.getMapper(EmployeeDtoMapper.class);


  //    @Mapping(source = "person.name", target="name" )
    EmployeeDto toDto(Employee e);
    List<EmployeeDto> toDtoList(List<Employee> e);
}
