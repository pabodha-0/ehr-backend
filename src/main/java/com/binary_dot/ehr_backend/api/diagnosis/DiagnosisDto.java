package com.binary_dot.ehr_backend.api.diagnosis;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisDto {
    private int id;
    private List<AppointmentDto> appointments;
    private String name;
}
