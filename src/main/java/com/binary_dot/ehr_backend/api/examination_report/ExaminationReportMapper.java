package com.binary_dot.ehr_backend.api.examination_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExaminationReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ExaminationReportDto mapToDto(ExaminationReport examinationReport) {
        return modelMapper.map(examinationReport, ExaminationReportDto.class);
    }

    public ExaminationReport mapToEntity(ExaminationReportDto examinationReportDto) {
        return modelMapper.map(examinationReportDto, ExaminationReport.class);
    }
}
