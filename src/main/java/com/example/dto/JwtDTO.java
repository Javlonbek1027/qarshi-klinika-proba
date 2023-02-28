package com.example.dto;

import com.example.enums.ProfileRole;

public class JwtDTO {
    private String email;
    private ProfileRole role;

    public JwtDTO(String email, ProfileRole role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileRole getRole() {
        return role;
    }

    public void setRole(ProfileRole role) {
        this.role = role;
    }
}



