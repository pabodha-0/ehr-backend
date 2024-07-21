package com.binary_dot.ehr_backend.api.examination_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/examination-report")
public class ExaminationReportController {
    @Autowired
    private ExaminationReportService examinationReportService;

    @PostMapping
    public ResponseEntity<ExaminationReportDto> createExaminationReport(@RequestBody ExaminationReportDto examinationReportDto) {
        return new ResponseEntity<>(examinationReportService.createExaminationReport(examinationReportDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ExaminationReportDto>> getAllExaminationReports() {
        return new ResponseEntity<>(examinationReportService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExaminationReportDto> getExaminationReportById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(examinationReportService.findById(id), HttpStatus.OK);
    }
}
