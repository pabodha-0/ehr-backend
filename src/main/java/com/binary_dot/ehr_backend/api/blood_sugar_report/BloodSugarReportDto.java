package com.binary_dot.ehr_backend.api.blood_sugar_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodSugarReportDto {
    private int id;

    private AppointmentDto appointment;

    private String fbs;

    private String ppbs;

    private String rbs;

    private String hba1c;
}
