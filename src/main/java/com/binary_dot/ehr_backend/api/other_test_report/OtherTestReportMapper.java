package com.binary_dot.ehr_backend.api.other_test_report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherTestReportMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OtherTestReportDto mapToDto(OtherTestReport otherTestReport) {
        return modelMapper.map(otherTestReport, OtherTestReportDto.class);
    }

    public OtherTestReport mapToEntity(OtherTestReportDto otherTestReportDto) {
        return modelMapper.map(otherTestReportDto, OtherTestReport.class);
    }
}
