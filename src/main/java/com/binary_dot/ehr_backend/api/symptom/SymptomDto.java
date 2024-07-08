package com.binary_dot.ehr_backend.api.symptom;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.appointment_symptom.AppointmentSymptomDto;
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
public class SymptomDto {
    private int id;

    private String name;

    @JsonIgnore
    private List<AppointmentSymptomDto> appointmentSymptoms;
}
