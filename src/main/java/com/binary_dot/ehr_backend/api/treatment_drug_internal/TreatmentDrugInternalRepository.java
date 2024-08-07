package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentDrugInternalRepository extends JpaRepository<TreatmentDrugInternal, Integer> {
}