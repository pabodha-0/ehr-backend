package com.binary_dot.ehr_backend.api.throat_infection_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThroatInfectionTypeDto {
    private int id;
    private List<ExaminationReportDto> examinationReports;
    private String name;
}
