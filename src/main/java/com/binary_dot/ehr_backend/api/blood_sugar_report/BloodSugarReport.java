package com.binary_dot.ehr_backend.api.blood_sugar_report;

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
@Table(name = "blood_sugar_report")
public class BloodSugarReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "bloodSugarReport")
    private Appointment appointment;

    private String fbs;

    private String ppbs;

    private String rbs;

    private String hba1c;
}
