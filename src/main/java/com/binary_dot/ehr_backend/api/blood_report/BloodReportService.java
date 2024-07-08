package com.binary_dot.ehr_backend.api.blood_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface BloodReportService {
    BloodReportDto addBloodReport(BloodReportDto bloodReportDto);
    BloodReportDto findById(int id) throws NotFoundException;
    List<BloodReportDto> getAllBloodReports();
}
