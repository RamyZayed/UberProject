package com.example.actualproject.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ApplicationUserDAO {

    public Optional<ApplicationUser> selectApplicationUserByUserName(String username);
}
