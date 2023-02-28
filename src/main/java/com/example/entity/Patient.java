package com.example.entity;

import com.example.entity.rooms.RoomForClients;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {//bemor

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id; //bemor id si

    @Column
    private String name; // ismi
    @Column
    private String surname; // familyasi
    @Column
    private int age; // yowi
    @Column
    private String kasallik_sababi;
    @Column
    private LocalDateTime kelgan_vaqti;
    @Column
    private LocalDateTime ketgan_vaqti;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomForClients room; // turgan honasi



}
