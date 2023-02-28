package com.example.dto;

import com.example.entity.Attach;
import com.example.entity.rooms.RoomForWorkers;
import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import com.example.enums.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFilterDto {

    private  String name; // ismi


    private  String surname; // familyasi

    private  String email; // emaili

    private String number;// telefon raqami

    private  String password; // paroli

    String attachId; // rasm idsi

    private ProfileStatus status; // iwlayabdimi yo'qmi bu odam bor mi o'zi yoki yo'qmi yoki chopilganim

    private ProfileRole role = ProfileRole.ROLE_ADVANCE_TRAINING; // kimligi

    private Specialty specialty; // mutahasisligi

    private Integer prtId; // ro'yhatdan o'tkazgan odam

    private RoomForWorkers roomForWork;
}
