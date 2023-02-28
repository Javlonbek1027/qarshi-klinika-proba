package com.example.dto;

import com.example.entity.Employee;
import com.example.enums.RoomForClientsStatus;
import com.example.enums.RoomPart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomForClientDto {
    private Integer number; // xona raqami

    private RoomPart part; // xonaning qaysi xonasidaligi 😁 g'alatiya (masalan 123A, 311C)

    private Integer capacity;// sig'imi (necha kiwi ketishi)

    private RoomForClientsStatus roomStatus;// bo'sh yoki yoqligi

    private String definition; // qisqacha malumotlar masalan xonada nimalar borligi itogdali itogdali

    private Long like; // likelar soni

    private Long disLike; // diLikelar soni

    private Employee responsible;
}
