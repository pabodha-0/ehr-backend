package com.binary_dot.ehr_backend.api.other_test_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.ecg_type.ECGTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtherTestReportDto {
    private int id;

    private AppointmentDto appointment;

    @JsonIgnoreProperties("otherTestReports")
    private ECGTypeDto ecgType;

    private String esr;

    private String crp;
}
