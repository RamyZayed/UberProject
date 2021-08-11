package com.example.actualproject.entity.dto;

import com.example.actualproject.entity.Address;
import com.example.actualproject.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonAddressMapper {

    PersonAddressMapper Instance = Mappers.getMapper(PersonAddressMapper.class);

    List<PersonAdressDTO> toDtoList(List<Person> p);
    @Mappings({
            @Mapping(source = "person.name", target = "personName"),
            @Mapping(source = "person.address.street", target = "street"),
            @Mapping(source = "person.address.city", target = "city")
    })
    PersonAdressDTO toDto(Person person);
}
