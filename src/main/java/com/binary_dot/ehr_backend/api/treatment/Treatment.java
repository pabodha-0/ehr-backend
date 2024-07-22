package com.binary_dot.ehr_backend.api.treatment;

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
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "treatment")
    private List<TreatmentDrugInternal> treatmentDrugInternalList;

    @OneToMany(mappedBy = "treatment")
    private List<TreatmentDrugExternal> treatmentDrugExternalList;
}
