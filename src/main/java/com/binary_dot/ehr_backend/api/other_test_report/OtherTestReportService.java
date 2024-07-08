package com.binary_dot.ehr_backend.api.other_test_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface OtherTestReportService {
    OtherTestReportDto addOtherTestReport(OtherTestReportDto otherTestReportDto);
    OtherTestReportDto findById(int id) throws NotFoundException;
    List<OtherTestReportDto> findAll();
}
