package com.binary_dot.ehr_backend.api.medical_history;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryDto {
    private int id;

    private PatientDto patient;

    private boolean dm;

    private boolean epilepsy;

    private boolean ht;

    private boolean cancer;

    private boolean ihd;

    private boolean ba;

    private boolean cva;
}
