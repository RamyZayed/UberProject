package com.example.actualproject;


import org.springframework.beans.factory.annotation.Value;

public interface PersonView {
//    String getName();

    @Value("#{target.name + ' ' + target.age}")
    String getNameWithAge();
}

