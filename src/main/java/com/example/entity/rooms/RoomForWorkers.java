package com.example.entity.rooms;

import com.example.entity.Employee;
import com.example.enums.RoomForClientsStatus;
import com.example.enums.RoomPart;
import com.example.enums.RoomStatusForWorkers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomForWorkers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id; // xona idsi

    @Column
    private Integer number; // xona raqami

    @Column
    private RoomPart part; // xonaning qaysi xonasidaligi 😁 g'alatiya (masalan 123A, 311C)

    @Column
    private Integer workers_capacity;// sig'imi (necha kiwi ketishi)

    @Enumerated(value = EnumType.STRING)
    @Column
    private RoomStatusForWorkers roomStatus;// bo'sh yoki yoqligi

    @Column
    private String definition; // qisqacha malumotlar masalan xonada nimalar borligi itogdali itogdali

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsible_employee", updatable = false, insertable = false)
    private Employee responsible; // javobgar shaxs

    @OneToMany(mappedBy="roomForWork")
    private Set<Employee> employees;  // xonada ishlovchilar

    @Column
    private Long like; // likelar soni

    @Column
    private Long disLike; // diLikelar soni
}
