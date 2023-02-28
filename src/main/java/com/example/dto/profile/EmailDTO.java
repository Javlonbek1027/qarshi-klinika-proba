package com.example.dto.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDTO {

    private Integer id;

    private String message;
    private String title;
    private String email;
    private LocalDateTime createdDate;
}
