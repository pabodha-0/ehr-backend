package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "urine_report")
public class UrineReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "urineReport")
    private Appointment appointment;

    private String albumin;
    private String sugar;
    private int pus_cells;
    private int red_cells;
    private String urine_culture;

}
