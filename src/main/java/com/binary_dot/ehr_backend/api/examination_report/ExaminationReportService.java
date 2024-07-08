package com.binary_dot.ehr_backend.api.examination_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface ExaminationReportService {
    ExaminationReportDto createExaminationReport(ExaminationReportDto examinationReportDto);
    ExaminationReportDto findById(int id) throws NotFoundException;
    List<ExaminationReportDto> findAll();
}
