package com.binary_dot.ehr_backend.api.treatment_drug_external;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyDto;
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

    private String dosage;

    private int days;

    private int qty;

    private DrugIntakeFrequencyDto drugIntakeFrequency;

    private AppointmentDto appointment;
}
