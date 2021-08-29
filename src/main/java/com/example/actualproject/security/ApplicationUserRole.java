/*
package com.example.actualproject.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {

    PERSON(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermession.PERSON_READ,ApplicationUserPermession.PERSON_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermession.PERSON_READ));

    private final Set<ApplicationUserPermession> permessions;

    ApplicationUserRole(Set<ApplicationUserPermession> permessions) {
        this.permessions = permessions;
    }

    public Set<ApplicationUserPermession> getPermessions() {
        return permessions;
    }

    //Because .authorities takes a list of the authorities for each ROle
    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permessions = getPermessions().stream()
                .map(permession -> new SimpleGrantedAuthority(permession.getPermession()))
                .collect(Collectors.toSet());

        permessions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permessions;
    }
}
*/
