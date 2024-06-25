package com.binary_dot.ehr_backend.api.patient_relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRelationRepository extends JpaRepository<PatientRelation, Integer> {
}
