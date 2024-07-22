package com.binary_dot.ehr_backend.api.treatment_drug_external;

import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequency;
import com.binary_dot.ehr_backend.api.treatment.Treatment;
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

    private int qty;

    private String dosage;

    @ManyToOne()
    @JoinColumn(name = "drug_intake_frequency_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DrugIntakeFrequency drugIntakeFrequency;

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;
}
