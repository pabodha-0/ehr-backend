package com.binary_dot.ehr_backend.api.patient_relation;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRelationDto {
    private int id;

    private PatientDto patient;

    private PatientDto relatedPatient;

    private String relation;
}
