package com.binary_dot.ehr_backend.api.examination_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/examination-report")
public class ExaminationReportController {
    @Autowired
    private ExaminationReportService examinationReportService;

    @PostMapping
    public ExaminationReportDto createExaminationReport(@RequestBody ExaminationReportDto examinationReportDto) {
        return examinationReportService.createExaminationReport(examinationReportDto);
    }

//    @GetMapping
//    public List<ExaminationReport> findAllExaminationReports() {}
}
