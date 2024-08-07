package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternal;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_intake_frequency")
public class DrugIntakeFrequency {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "times_per_day")
    private int timesPerDay;

    @OneToMany(mappedBy = "drugIntakeFrequency", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<TreatmentDrugInternal> treatmentDrugInternalList;

    @OneToMany(mappedBy = "drugIntakeFrequency", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<TreatmentDrugExternal> treatmentDrugExternalList;
}
