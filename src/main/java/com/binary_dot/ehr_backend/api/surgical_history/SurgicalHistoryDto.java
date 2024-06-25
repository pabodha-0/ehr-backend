package com.binary_dot.ehr_backend.api.surgical_history;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurgicalHistoryDto {
    private int id;

    private PatientDto patient;

    private boolean surgery;
}
