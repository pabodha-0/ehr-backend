package com.binary_dot.ehr_backend.api.drug_info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugInfoRepository extends JpaRepository<DrugInfo, Integer> {

}