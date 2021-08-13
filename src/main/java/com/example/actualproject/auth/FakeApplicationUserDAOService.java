package com.example.actualproject.auth;

import com.example.actualproject.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDAOService implements ApplicationUserDAO{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDAOService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()) )
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(

                new ApplicationUser(
                        ApplicationUserRole.PERSON.getGrantedAuthorities(),
                        passwordEncoder.encode("pass"),
                        "Anwar",
                        true,
                        true,
                        true,
                        true
                )  ,
                new ApplicationUser(
                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("pass"),
                        "Harith",
                        true,
                        true,
                        true,
                        true
                )   ,
                new ApplicationUser(
                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("pass"),
                        "Tom",
                        true,
                        true,
                        true,
                        true
                )




        );


        return applicationUsers;
    }
}
