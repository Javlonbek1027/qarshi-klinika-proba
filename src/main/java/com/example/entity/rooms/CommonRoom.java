//package com.example.entity.rooms;
//
//import com.example.entity.Employee;
//import com.example.enums.RoomForClientsStatus;
//import com.example.enums.RoomPart;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class CommonRoom {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id; // xona idsi
//
//    @Column
//    private Integer number; // xona raqami
//
//    @Column
//    private RoomPart part; // xonaning qaysi xonasidaligi 😁 g'alatiya (masalan 123A, 311C)
//
//    @Column
//    private Integer capacity;// sig'imi (necha kiwi ketishi)
//
//    @Enumerated(value = EnumType.STRING)
//    @Column
//    private RoomForClientsStatus roomStatus;// bo'sh yoki yoqligi
//
//    @Column
//    private String definition; // qisqacha malumotlar masalan xonada nimalar borligi itogdali itogdali
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "responsible_employee", updatable = false, insertable = false)
//    private Employee responsible;
//
//}
