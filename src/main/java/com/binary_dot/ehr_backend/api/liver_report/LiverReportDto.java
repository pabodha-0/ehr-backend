package com.binary_dot.ehr_backend.api.liver_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LiverReportDto {
    private int id;

    private AppointmentDto appointment;

    private String gammaGT;

    private String sgotAST;

    private String sgptALT;

    private String totalBilirubin;

    private String directBilirubin;

    private String indirectBilirubin;
}
