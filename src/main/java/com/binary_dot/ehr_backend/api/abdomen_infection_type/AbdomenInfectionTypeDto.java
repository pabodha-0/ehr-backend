package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Abdomen Infection Type cannot be null")
    private String name;

    @JsonIgnore
    private List<ExaminationReportDto> examinationReports;
}
