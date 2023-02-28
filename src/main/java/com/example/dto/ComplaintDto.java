package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDto {
    public ComplaintDto(Integer patientId, String complaint) {
        this.patientId = patientId;
        this.complaint = complaint;
    }

    private Integer id;
    private Integer patientId;
    private String complaint;
}
