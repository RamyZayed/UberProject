package com.example.actualproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLogInView(){
        return "login";
    }

    @GetMapping("second")
    public String getStudents(){
        return "second";
    }



}
