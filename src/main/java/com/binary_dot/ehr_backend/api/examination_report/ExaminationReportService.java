package com.binary_dot.ehr_backend.api.examination_report;

import java.util.List;

public interface ExaminationReportService {
    ExaminationReportDto createExaminationReport(ExaminationReportDto examinationReportDto);
    ExaminationReportDto findById(int id);
    List<ExaminationReportDto> findAll();
}
