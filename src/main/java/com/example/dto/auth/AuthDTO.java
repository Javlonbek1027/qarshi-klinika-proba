package com.example.dto.auth;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    @Size(min = 3, max = 50)
    private String password;
    @Size(min = 3, max = 50)
    private String email;

    public AuthDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public AuthDTO() {
    }
}
