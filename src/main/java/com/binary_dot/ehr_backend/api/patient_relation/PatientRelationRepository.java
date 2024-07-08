package com.binary_dot.ehr_backend.api.patient_relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRelationRepository extends JpaRepository<PatientRelation, Integer> {
    List<PatientRelation> findByPatientId(int patientId);
}
