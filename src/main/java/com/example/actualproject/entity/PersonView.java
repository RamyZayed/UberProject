package com.example.actualproject.entity;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;




public interface PersonView {

   // String getName();
    //int getAge();

    @Value("#{target.name + ' ' + target.age}")
    String getNameWithAge();
}

