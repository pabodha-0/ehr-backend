package com.binary_dot.ehr_backend.api.medical_history;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalHistoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public MedicalHistoryDto mapToDto(MedicalHistory medicalHistory) {
        return modelMapper.map(medicalHistory, MedicalHistoryDto.class);
    }

    public MedicalHistory mapToEntity(MedicalHistoryDto medicalHistoryDto) {
        return modelMapper.map(medicalHistoryDto, MedicalHistory.class);
    }
}
