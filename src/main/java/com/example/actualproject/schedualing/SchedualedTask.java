package com.example.actualproject.schedualing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedualedTask {

    @Scheduled(fixedRate = 5000)
    public void matask(){

        System.out.println(LocalDateTime.now());
    }
}


