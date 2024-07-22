package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDrugInternalId {
    @Column(name = "treatment_id")
    private int treatmentId;

    @Column(name = "drug_info_id")
    private int drugInfoId;
}
