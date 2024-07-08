package com.binary_dot.ehr_backend.api.kidney_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface KidneyReportService {
    KidneyReportDto addKidneyReport(KidneyReportDto kidneyReportDto);
    KidneyReportDto findById(int id) throws NotFoundException;
    List<KidneyReportDto> findAll();
}
