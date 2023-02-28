package com.example.config;

import com.example.entity.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Profile profile;

    public CustomUserDetails(Profile profile) {
        this.profile = profile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("get Role");

        List<GrantedAuthority> list = new LinkedList<>();
        list.add(new SimpleGrantedAuthority(profile.getRole().name()));

        return list;
    }

    @Override
    public String getPassword() {
        System.out.println("get Password");
        return profile.getPassword();
    }

    @Override
    public String getUsername() {
        return profile.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        System.out.println("get  isEnabled");

        // status
        return true;
    }

    public Profile getProfile() {
        return profile;
    }
}