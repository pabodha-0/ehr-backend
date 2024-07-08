package com.binary_dot.ehr_backend.api.blood_sugar_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface BloodSugarReportService {
    BloodSugarReportDto addBloodSugarReport(BloodSugarReportDto bloodSugarReportDto);
    BloodSugarReportDto findById(int id) throws NotFoundException;
    List<BloodSugarReportDto> findAll();
}
