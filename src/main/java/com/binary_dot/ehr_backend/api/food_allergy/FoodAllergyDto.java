package com.binary_dot.ehr_backend.api.food_allergy;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
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
public class FoodAllergyDto {
    private int id;

    private String name;

    @JsonIgnore
    private List<PatientDto> patients;
}
