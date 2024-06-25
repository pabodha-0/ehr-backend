package com.binary_dot.ehr_backend.api.blood_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodReportImpl implements BloodReportService{
    @Autowired
    private BloodReportRepository bloodReportRepository;

    @Autowired
    private BloodReportMapper bloodReportMapper;

    @Override
    public BloodReportDto addBloodReport(BloodReportDto bloodReportDto) {
        BloodReport bloodReport = bloodReportRepository.save(bloodReportMapper.mapToEntity(bloodReportDto));
        return bloodReportMapper.mapToDto(bloodReport);
    }
}
