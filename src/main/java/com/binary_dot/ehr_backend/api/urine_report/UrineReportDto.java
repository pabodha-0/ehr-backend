package com.binary_dot.ehr_backend.api.urine_report;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrineReportDto {
    private int id;

    private AppointmentDto appointment;

    @JsonIgnoreProperties("urineReports")
    private UrineCultureTypeDto urineCultureType;

    private String albumin;

    private String sugar;

    private int pusCells;

    private int redCells;

}
