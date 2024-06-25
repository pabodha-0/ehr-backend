package com.binary_dot.ehr_backend.api.liver_report;

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
@Table(name = "liver_report")
public class LiverReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "liverReport")
    private Appointment appointment;

    @Column(name = "gamma_gt")
    private String gammaGT;

    @Column(name = "sgot_ast")
    private String sgotAST;

    @Column(name = "sgpt_alt")
    private String sgptALT;

    @Column(name = "total_bilirubin")
    private String totalBilirubin;

    @Column(name = "direct_bilirubin")
    private String directBilirubin;

    @Column(name = "indirect_bilirubin")
    private String indirectBilirubin;
}
