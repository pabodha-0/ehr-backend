package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.drug_info.DrugInfoDto;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String dosage;

    private int days;

    private int qty;

    private AppointmentDto appointment;

    @JsonIgnoreProperties("treatmentDrugInternalList")
    private DrugInfoDto drugInfo;

    @JsonIgnoreProperties("treatmentDrugInternalList")
    private DrugIntakeFrequencyDto drugIntakeFrequency;
}
