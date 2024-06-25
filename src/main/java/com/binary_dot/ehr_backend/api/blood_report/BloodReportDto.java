package com.binary_dot.ehr_backend.api.blood_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodReportDto {
    private int id;

    private AppointmentDto appointment;

    private String n;

    private String l;

    private String e;

    private String m;

    private String b;

    private String hemoglobin;

    private String pcv;

    private String platelets;
}
