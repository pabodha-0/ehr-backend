package com.binary_dot.ehr_backend.api.patient_relation;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnore
    private PatientDto patient;

    @JsonIgnoreProperties({"appointments", "foodAllergies", "drugAllergies", "relations"})
    private PatientDto relatedPatient;

    private String relation;
}
