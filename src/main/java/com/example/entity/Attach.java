package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id; // id si

    @Column(name = "original_name")
    private String originalName; // yuklangan bo'yicha haqiqiy nomi

    @Column
    private String path; // turgan papkasi yo'li

    @Column
    private Long size; // necha megaytligi

    @Column
    private String extension; // rasm formati (masalan jpg, png)

    @Column(name = "created_date")
    private LocalDateTime createdData; // kiritilgan vaqti

    @Column
    private Long duration; //

}
