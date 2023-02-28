package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDTO {
    private String id;
    private String originalName;
    private String path;
    private String url;
    private Long size;
    private String extension;
    private LocalDateTime createdData;
    private Long duration;
}
