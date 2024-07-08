package com.binary_dot.ehr_backend.api.thyroid_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface ThyroidReportService {
    ThyroidReportDto addThyroidReport(ThyroidReportDto thyroidReportDto);
    ThyroidReportDto findById(int id) throws NotFoundException;
    List<ThyroidReportDto> findAll();
}
