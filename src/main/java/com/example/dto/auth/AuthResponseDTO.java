package com.example.dto.auth;

import com.example.enums.ProfileRole;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponseDTO {
    @Size(min = 3, max = 50)
    private String name;
    @Size(min = 3, max = 50)
    private String surname;
    @Size(min = 3, max = 10)
    private ProfileRole role;
    private String token;
}