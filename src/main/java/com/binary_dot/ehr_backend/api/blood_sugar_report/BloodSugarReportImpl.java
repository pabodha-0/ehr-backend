package com.binary_dot.ehr_backend.api.blood_sugar_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodSugarReportImpl implements BloodSugarReportService {
    @Autowired
    private BloodSugarReportRepository bloodSugarReportRepository;

    @Autowired
    private BloodSugarReportMapper bloodSugarReportMapper;

    @Override
    public BloodSugarReportDto addBloodSugarReport(BloodSugarReportDto bloodSugarReportDto) {
        BloodSugarReport bloodSugarReport = bloodSugarReportRepository.save(bloodSugarReportMapper.mapToEntity(bloodSugarReportDto));
        return bloodSugarReportMapper.mapToDto(bloodSugarReport);
    }
}
