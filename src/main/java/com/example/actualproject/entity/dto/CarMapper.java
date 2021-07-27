package com.example.actualproject.entity.dto;

import com.example.actualproject.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper Instance = Mappers.getMapper(CarMapper.class);

   // CarMapper toDto(Car car);
}
