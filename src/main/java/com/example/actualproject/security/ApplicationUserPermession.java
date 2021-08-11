package com.example.actualproject.security;

public enum ApplicationUserPermession {
    PERSON_READ("person:read"),
    PERSON_WRITE("person:write");


    private final String permession;

    ApplicationUserPermession(String permession){
        this.permession=permession;
    }

    public String getPermession(){
        return permession;
    }
}
