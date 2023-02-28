package com.example.entity.rooms;

import com.example.entity.Employee;
import com.example.enums.RoomForClientsStatus;
import com.example.enums.RoomPart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomForClients {  // bu xona kasallar yoki davolanayotganar uchun


    public RoomForClients(Integer number, RoomPart part, Integer capacity, RoomForClientsStatus roomStatus, String definition, Long like, Long disLike, Employee responsible) {
        this.number = number;
        this.part = part;
        this.capacity = capacity;
        this.roomStatus = roomStatus;
        this.definition = definition;
        this.like = like;
        this.disLike = disLike;
        this.responsible = responsible;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id; // xona idsi

    @Column
    private Integer number; // xona raqami

    @Column
    private RoomPart part; // xonaning qaysi xonasidaligi 😁 g'alatiya (masalan 123A, 311C)

    @Column
    private Integer capacity;// sig'imi (necha kiwi ketishi)

    @Enumerated(value = EnumType.STRING)
    @Column
    private RoomForClientsStatus roomStatus;// bo'sh yoki yoqligi

    @Column
    private String definition; // qisqacha malumotlar masalan xonada nimalar borligi itogdali itogdali

    @Column
    private Long like; // likelar soni

    @Column
    private Long disLike; // diLikelar soni
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsible_employee", updatable = false, insertable = false)
    private Employee responsible;



}
