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
@Table(name = "kidney_report")
public class KidneyReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kidneyReport")
    private Appointment appointment;

    private String serum_creatinine;
    private String blood_urea;
    private String serum_electrolytes_na;
    private String serum_electrolytes_k;
    private String serum_electrolytes_cl;
}
