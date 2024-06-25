package com.binary_dot.ehr_backend.api.urine_culture_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrineCultureTypeRepository extends JpaRepository<UrineCultureType, Integer> {
    List<UrineCultureType> findByName(String name);
}
