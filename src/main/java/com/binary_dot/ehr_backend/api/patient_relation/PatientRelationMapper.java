package com.binary_dot.ehr_backend.api.patient_relation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientRelationMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PatientRelationDto mapToDto(PatientRelation patientRelation) {return modelMapper.map(patientRelation, PatientRelationDto.class);}

    public PatientRelation mapToEntity(PatientRelationDto patientRelationDto) {return modelMapper.map(patientRelationDto, PatientRelation.class);}
}
