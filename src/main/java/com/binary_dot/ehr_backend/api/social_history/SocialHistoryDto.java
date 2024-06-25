package com.binary_dot.ehr_backend.api.social_history;

import com.binary_dot.ehr_backend.api.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialHistoryDto {
    private int id;

    private PatientDto patient;

    private boolean alcoholic;

    private boolean smoking;
}
