package com.example.actualproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    private String trip_id;
    private int price;
    private String customer_id;
    private String emp_id;
    private String from;
    private String destination;
}
