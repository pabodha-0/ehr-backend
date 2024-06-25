package com.binary_dot.ehr_backend.api.patient_relation;

import java.util.List;

public interface PatientRelationService {
    PatientRelationDto createPatientRelation(PatientRelationDto patientRelationDto);
    PatientRelationDto findById(int id);
    List<PatientRelationDto> findAll();

}
