package com.binary_dot.ehr_backend.api.treatment_drug_external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentDrugExternalRepository extends JpaRepository<TreatmentDrugExternal, Integer> {

}