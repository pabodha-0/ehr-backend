package com.binary_dot.ehr_backend.api.liver_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiverReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LiverReportDto mapToDto(LiverReport liverReport) {
        return modelMapper.map(liverReport, LiverReportDto.class);
    }

    public LiverReport mapToEntity(LiverReportDto liverReportDto) {
        return modelMapper.map(liverReportDto, LiverReport.class);
    }
}
