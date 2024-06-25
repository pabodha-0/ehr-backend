package com.binary_dot.ehr_backend.api.symptom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Integer> {
    List<Symptom> findByName(String name);
}
