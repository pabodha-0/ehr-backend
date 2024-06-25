package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugIntakeFrequencyDto {
    private int id;
    private String name;
    private int timesPerDay;
}
