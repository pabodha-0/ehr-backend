package com.binary_dot.ehr_backend.api.treatment_drug_external;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "treatment_drug_external")
public class TreatmentDrugExternal {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    private String dosage;

    private int days;

    private int qty;

    @ManyToOne()
    @JoinColumn(name = "drug_intake_frequency_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DrugIntakeFrequency drugIntakeFrequency;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}
