package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternalDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private List<TreatmentDrugInternalDto> treatmentDrugInternalList;

    @JsonIgnore
    private List<TreatmentDrugExternalDto> treatmentDrugExternalList;
}
