package com.binary_dot.ehr_backend.api.patient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PatientDto mapToDto(Patient patient) {
        return modelMapper.map(patient, PatientDto.class);
    }

    public Patient mapToEntity(PatientDto patientDto) {
        return modelMapper.map(patientDto, Patient.class);
    }
}
