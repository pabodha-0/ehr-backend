package com.binary_dot.ehr_backend.api.patient_relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientRelationImpl implements PatientRelationService {
    @Autowired
    private PatientRelationRepository patientRelationRepository;

    @Autowired
    private PatientRelationMapper patientRelationMapper;

    @Override
    public PatientRelationDto createPatientRelation(PatientRelationDto patientRelationDto) {
        PatientRelation patientRelation = patientRelationRepository.save(patientRelationMapper.mapToEntity(patientRelationDto));
        return patientRelationMapper.mapToDto(patientRelation);
    }

    @Override
    public List<PatientRelationDto> findAllByPatientId(int id) {
        List<PatientRelation> patientRelations = patientRelationRepository.findByPatientId(id);
        return patientRelations.stream().map(relation -> patientRelationMapper.mapToDto(relation)).toList();
    }

    @Override
    public List<PatientRelationDto> findAll() {
        List<PatientRelation> patientRelations = patientRelationRepository.findAll();
        return patientRelations.stream().map(relation -> patientRelationMapper.mapToDto(relation)).toList();
    }
}
