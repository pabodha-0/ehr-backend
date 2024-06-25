package com.binary_dot.ehr_backend.api.ecg_type;

import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ECGTypeDto {
    private int id;

    private List<OtherTestReportDto> otherTestReports;

    private String name;
}
