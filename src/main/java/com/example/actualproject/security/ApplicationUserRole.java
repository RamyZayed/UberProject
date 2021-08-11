package com.example.actualproject.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(ApplicationUserPermession.PERSON_READ)),
    ADMIN(Sets.newHashSet(ApplicationUserPermession.PERSON_READ,ApplicationUserPermession.PERSON_WRITE));

    private final Set<ApplicationUserPermession> permessions;

    ApplicationUserRole(Set<ApplicationUserPermession> permessions) {
        this.permessions = permessions;
    }

    public Set<ApplicationUserPermession> getPermessions() {
        return permessions;
    }
}
