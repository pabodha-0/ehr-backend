package com.binary_dot.ehr_backend.api.other_test_report;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.ecg_type.ECGType;
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
@Table(name = "other_test_report")
public class OtherTestReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "otherTestReport")
    private Appointment appointment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="ecg_type_id")
    private ECGType ecgType;

    private String esr;

    private String crp;
}
