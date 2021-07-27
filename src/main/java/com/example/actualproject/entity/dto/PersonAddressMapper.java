package com.example.actualproject.entity.dto;

import com.example.actualproject.entity.Address;
import com.example.actualproject.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonAddressMapper {

    PersonAddressMapper Instance = Mappers.getMapper(PersonAddressMapper.class);

    @Mapping(source = "person.name" , target = "personName")
    PersonAdressDTO toDto(Person person, Address address);
}
