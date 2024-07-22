package com.binary_dot.ehr_backend.api.treatment_drug_external;

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
public class TreatmentDrugExternalDto {
    private int id;

    private String name;

    private int qty;

    private String dosage;

    private DrugIntakeFrequencyDto drugIntakeFrequency;

    private TreatmentDto treatment;
}
