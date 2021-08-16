package com.example.actualproject.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDAO applicationUserDAO;

    @Autowired
    public ApplicationUserService( ApplicationUserDAO applicationUserDAO) {
        this.applicationUserDAO = applicationUserDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return applicationUserDAO.selectApplicationUserByUserName(userName)
                .orElseThrow( ()->
                        new UsernameNotFoundException(String.format("User name %s not found",userName))
                );
    }
}
