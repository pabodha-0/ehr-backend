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
@Table(name = "liver_report")
public class LiverReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "liverReport")
    private Appointment appointment;

    private String gamma_gt;
    private String sgot_ast;
    private String sgpt_alt;
    private String total_bilirubin;
    private String direct_bilirubin;
    private String indirect_bilirubin;
}
