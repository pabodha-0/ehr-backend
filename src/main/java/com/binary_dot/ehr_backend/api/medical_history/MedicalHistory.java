package com.binary_dot.ehr_backend.api.medical_history;

import com.binary_dot.ehr_backend.api.patient.Patient;
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
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "medicalHistory")
    private Patient patient;

    private boolean dm;

    private boolean epilepsy;

    private boolean ht;

    private boolean cancer;

    private boolean ihd;

    private boolean ba;

    private boolean cva;
}
