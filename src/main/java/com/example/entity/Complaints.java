package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Complaints { // shikoyatlar


    public Complaints(Integer patientId, String complaint) {
        this.patientId = patientId;
        this.complaint = complaint;
    }

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "bemor_id" )
    private Integer patientId;
    @ManyToOne
    @JoinColumn(name = "bemor_id", insertable = false, updatable = false)
    private Patient patient;

    @Column
    private String complaint;
}
