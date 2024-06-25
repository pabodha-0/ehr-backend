package com.binary_dot.ehr_backend.api.thyroid_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThyroidReportDto {
    private int id;

    private AppointmentDto appointment;

    private String tsh;

    private String t3;

    private String t4;
}
