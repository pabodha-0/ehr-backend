package com.binary_dot.ehr_backend.api.kidney_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KidneyReportDto {
    private int id;

    private AppointmentDto appointment;

    private String serumCreatinine;

    private String bloodUrea;

    private String serumElectrolytesNA;

    private String serumElectrolytesK;

    private String serumElectrolytesCL;
}
