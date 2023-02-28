package com.example.dto.auth;

import com.example.dto.AttachDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String mainPhotoId;
    private AttachDTO mainPhoto;
    private  String password;
}
