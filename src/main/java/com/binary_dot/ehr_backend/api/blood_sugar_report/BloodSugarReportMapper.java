package com.binary_dot.ehr_backend.api.blood_sugar_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BloodSugarReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BloodSugarReportDto mapToDto(BloodSugarReport bloodSugarReport) {
        return modelMapper.map(bloodSugarReport, BloodSugarReportDto.class);
    }

    public BloodSugarReport mapToEntity(BloodSugarReportDto bloodReportDto) {
        return modelMapper.map(bloodReportDto, BloodSugarReport.class);
    }
}
