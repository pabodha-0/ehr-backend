package com.binary_dot.ehr_backend.api.kidney_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KidneyReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public KidneyReportDto mapToDto(KidneyReport kidneyReport) {
        return modelMapper.map(kidneyReport, KidneyReportDto.class);
    }

    public KidneyReport mapToEntity(KidneyReportDto kidneyReportDto) {
        return modelMapper.map(kidneyReportDto, KidneyReport.class);
    }
}
