package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternalDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugIntakeFrequencyDto {
    private int id;

    private String name;

    private int timesPerDay;

    private List<TreatmentDrugInternalDto> treatmentDrugInternalList;

    private List<TreatmentDrugExternalDto> treatmentDrugExternalList;
}
