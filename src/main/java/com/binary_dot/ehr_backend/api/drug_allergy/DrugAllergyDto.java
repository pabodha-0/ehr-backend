package com.binary_dot.ehr_backend.api.drug_allergy;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugAllergyDto {
    private int id;

    private List<PatientDto> patients;

    private String name;
}
