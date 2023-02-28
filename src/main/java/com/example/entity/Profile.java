package com.example.entity;

import com.example.enums.ProfileRole;
import com.example.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

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
    private String number; // telefon raqami
    //id,name,surname,email,photo,role,status
    @Column(length = 200)
    private  String password; // paroli

    @Column(name = "attach_id")
    String attachId; // rasm id si
    @OneToOne
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private Attach attach; // profil rasmi

    @Enumerated(value = EnumType.STRING)
    private ProfileStatus status = ProfileStatus.NOT_ACTIVE;// bu odam bor mi o'zi yoki yo'qmi yoki bloklangami

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProfileRole role = ProfileRole.ROLE_USER;// kimligi

}
