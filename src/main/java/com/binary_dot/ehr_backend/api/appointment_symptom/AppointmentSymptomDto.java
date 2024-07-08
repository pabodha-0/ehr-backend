package com.binary_dot.ehr_backend.api.appointment_symptom;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.symptom.SymptomDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentSymptomDto {
    private AppointmentDto appointment;

    private SymptomDto symptom;

    private String duration;
}
