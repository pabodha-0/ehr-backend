package com.binary_dot.ehr_backend.api.kidney_report;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
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

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "kidneyReport")
    private Appointment appointment;

    @Column(name = "serum_creatinine")
    private String serumCreatinine;

    @Column(name = "blood_urea")
    private String bloodUrea;

    @Column(name = "serum_electrolytes_na")
    private String serumElectrolytesNA;

    @Column(name = "serum_electrolytes_k")
    private String serumElectrolytesK;

    @Column(name = "serum_electrolytes_cl")
    private String serumElectrolytesCL;
}
