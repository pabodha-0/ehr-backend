package com.binary_dot.ehr_backend.api.thyroid_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThyroidReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ThyroidReportDto mapToDto(ThyroidReport thyroidReport) {
        return modelMapper.map(thyroidReport, ThyroidReportDto.class);
    }

    public ThyroidReport mapToEntity(ThyroidReportDto thyroidReportDto) {
        return modelMapper.map(thyroidReportDto, ThyroidReport.class);
    }
}
