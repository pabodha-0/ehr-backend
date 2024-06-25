package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbdomenInfectionTypeDto {
    private int id;

    @NotBlank
    private String name;

    private List<ExaminationReportDto> examinationReports;
}
