package com.binary_dot.ehr_backend.api.urine_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UrineReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UrineReportDto mapToDto(UrineReport urineReport) {
        return modelMapper.map(urineReport, UrineReportDto.class);
    }

    public UrineReport mapToEntity(UrineReportDto urineReportDto) {
        return modelMapper.map(urineReportDto, UrineReport.class);
    }

}
