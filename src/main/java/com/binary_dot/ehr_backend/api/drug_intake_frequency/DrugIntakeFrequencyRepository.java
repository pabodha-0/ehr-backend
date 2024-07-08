package com.binary_dot.ehr_backend.api.drug_intake_frequency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugIntakeFrequencyRepository extends JpaRepository<DrugIntakeFrequency, Integer> {
    List<DrugIntakeFrequency> findByName(String name);
}
