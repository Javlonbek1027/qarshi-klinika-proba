package com.example.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorazitionDTO {
    private Integer id;
    private String email;

    public AuthorazitionDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }
}
