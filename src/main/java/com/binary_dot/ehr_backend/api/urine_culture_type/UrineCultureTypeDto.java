package com.binary_dot.ehr_backend.api.urine_culture_type;

import com.binary_dot.ehr_backend.api.urine_report.UrineReportDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrineCultureTypeDto {
    private int id;

    private String name;

    @JsonIgnore
    private List<UrineReportDto> urineReports;
}
