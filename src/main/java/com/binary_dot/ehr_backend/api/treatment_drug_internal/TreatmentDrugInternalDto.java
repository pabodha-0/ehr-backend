package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfoDto;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyDto;
import com.binary_dot.ehr_backend.api.treatment.TreatmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDrugInternalDto {
    TreatmentDrugInternalId id;

    private TreatmentDto treatment;

    private DrugInfoDto drugInfo;

    private DrugIntakeFrequencyDto drugIntakeFrequency;
}
