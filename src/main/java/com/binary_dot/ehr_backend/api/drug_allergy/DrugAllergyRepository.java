package com.binary_dot.ehr_backend.api.drug_allergy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugAllergyRepository extends JpaRepository<DrugAllergy, Integer> {
    List<DrugAllergy> findByName(String name);
}
