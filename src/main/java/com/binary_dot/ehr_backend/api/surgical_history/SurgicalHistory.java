package com.binary_dot.ehr_backend.api.surgical_history;

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
@Table(name = "surgical_history")
public class SurgicalHistory {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "surgicalHistory")
    private Patient patient;

    private boolean surgery;
}
