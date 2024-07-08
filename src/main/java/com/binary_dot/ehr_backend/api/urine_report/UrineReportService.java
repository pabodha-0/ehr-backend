package com.binary_dot.ehr_backend.api.urine_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface UrineReportService {
    UrineReportDto addUrineReport(UrineReportDto urineReportDto);
    UrineReportDto findById(int id) throws NotFoundException;
    List<UrineReportDto> findAll();
}
