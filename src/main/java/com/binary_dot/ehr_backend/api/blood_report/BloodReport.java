package com.binary_dot.ehr_backend.api.blood_report;

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
@Table(name = "blood_report")
public class BloodReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "bloodReport")
    private Appointment appointment;

    private String n;

    private String l;

    private String e;

    private String m;

    private String b;

    private String hemoglobin;

    private String pcv;

    private String platelets;
}
