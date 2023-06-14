package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public enum Role {
    USER,
    ADMIN;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
