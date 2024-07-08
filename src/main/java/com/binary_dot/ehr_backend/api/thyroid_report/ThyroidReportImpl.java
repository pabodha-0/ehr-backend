package com.binary_dot.ehr_backend.api.thyroid_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ThyroidReportDto findById(int id) throws NotFoundException {
        ThyroidReport thyroidReport = thyroidReportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Thyroid report not found by Id: " + id )
        );
        return thyroidReportMapper.mapToDto(thyroidReport);
    }

    @Override
    public List<ThyroidReportDto> findAll() {
        List<ThyroidReport> thyroidReports = thyroidReportRepository.findAll();
        return thyroidReports.stream().map(report -> thyroidReportMapper.mapToDto(report)).toList();
    }
}
