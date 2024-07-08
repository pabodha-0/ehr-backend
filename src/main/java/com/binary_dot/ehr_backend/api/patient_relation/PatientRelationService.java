package com.binary_dot.ehr_backend.api.patient_relation;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface PatientRelationService {
    PatientRelationDto createPatientRelation(PatientRelationDto patientRelationDto);
    List<PatientRelationDto> findAllByPatientId(int id);
    List<PatientRelationDto> findAll();

}
