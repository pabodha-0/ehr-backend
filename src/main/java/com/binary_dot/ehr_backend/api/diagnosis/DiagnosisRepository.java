package com.binary_dot.ehr_backend.api.diagnosis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    List<Diagnosis> findByName(String name);
}
