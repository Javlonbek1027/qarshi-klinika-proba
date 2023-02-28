package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CameAndWent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee; // ishchi

    @Column
    private LocalDateTime cameInTime; // iwga kelgan vaqti

    @Column
    private LocalDateTime wentInTime; // iwdan ketgan vaqti

    @Column(columnDefinition = "varchar(255) default 'Vaqtida ketdi!'")
    private String reasonToLeave; // agar iwdan qaysidur sababga ko'ra ketiwiga to'ri kelsa ketiw sababi(agar o'z vaqtida ketsa mummo yo'q hechnarsa yozmaydi)


}
