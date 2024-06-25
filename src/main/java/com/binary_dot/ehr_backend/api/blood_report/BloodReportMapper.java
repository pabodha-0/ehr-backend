package com.binary_dot.ehr_backend.api.blood_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BloodReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BloodReportDto mapToDto(BloodReport bloodReport) {
        return modelMapper.map(bloodReport, BloodReportDto.class);
    }

    public BloodReport mapToEntity(BloodReportDto bloodReportDto) {
        return modelMapper.map(bloodReportDto, BloodReport.class);
    }
}
