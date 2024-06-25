package com.binary_dot.ehr_backend.api.diagnosis;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosisMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DiagnosisDto mapToDto(Diagnosis diagnosis) {
        return modelMapper.map(diagnosis, DiagnosisDto.class);
    }

    public Diagnosis mapToEntity(DiagnosisDto diagnosisDto) {
        return modelMapper.map(diagnosisDto, Diagnosis.class);
    }
}
