package com.binary_dot.ehr_backend.api.liver_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface LiverReportService {
    LiverReportDto addLiverReport(LiverReportDto liverReportDto);
    LiverReportDto findById(int id) throws NotFoundException;
    List<LiverReportDto> findAll();
}
