package com.example.dto.profile;

import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    public ProfileDTO(String name,
                      String surname,
                      String email,
                      String password,
                      ProfileRole role,
                      LocalDateTime createdDate,
                      LocalDateTime updateDate,
                      String imageId,
                      String imagePath,
                      ProfileStatus status,
                      Integer prtId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.status = status;
        this.prtId = prtId;
    }

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ProfileRole role;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updateDate;
    private String imageId;
    private String imagePath;

    private ProfileStatus status;


    private Integer prtId;

}
