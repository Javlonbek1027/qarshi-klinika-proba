package com.example.entity;

import com.example.entity.rooms.RoomForWorkers;
import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.example.enums.Specialty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // id si

    @Column(length = 50)
    private  String name; // ismi

    @Column(length = 50)
    private  String surname; // familyasi

    @Column(length = 50,unique = true)
    private  String email; // emaili

    @Column
    private String number;// telefon raqami


    @Column
    @Length(max = 18, min = 6)
    private  String password; // paroli

    @Column(name = "attach_id")
    String attachId; // rasm idsi
    @OneToOne
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private Attach attach; // bu inson rasmi

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProfileStatus status; // iwlayabdimi yo'qmi bu odam bor mi o'zi yoki yo'qmi yoki chopilganim

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProfileRole role = ProfileRole.ROLE_ADVANCE_TRAINING; // kimligi

    @Enumerated(value = EnumType.STRING)
    @Column
    private Specialty specialty; // mutahasisligi
    @Column
    private Integer prtId; // ro'yhatdan o'tkazgan odam

    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private RoomForWorkers roomForWork;

    @Column
    private Long like; // likelar soni

    @Column
    private Long disLike; // diLikelar soni
}
