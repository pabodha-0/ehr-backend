package com.binary_dot.ehr_backend.api.thyroid_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThyroidReportImpl implements ThyroidReportService{
    @Autowired
    ThyroidReportRepository thyroidReportRepository;

    @Autowired
    ThyroidReportMapper thyroidReportMapper;


    @Override
    public ThyroidReportDto addThyroidReport(ThyroidReportDto thyroidReportDto) {
        ThyroidReport thyroidReport = thyroidReportRepository.save(thyroidReportMapper.mapToEntity(thyroidReportDto));
        return thyroidReportMapper.mapToDto(thyroidReport);
    }
}
