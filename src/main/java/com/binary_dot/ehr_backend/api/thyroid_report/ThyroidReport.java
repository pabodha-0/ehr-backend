package com.binary_dot.ehr_backend.api.thyroid_report;

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
@Table(name = "thyroid_report")
public class ThyroidReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "thyroidReport")
    private Appointment appointment;

    private String tsh;

    private String t3;

    private String t4;
}
