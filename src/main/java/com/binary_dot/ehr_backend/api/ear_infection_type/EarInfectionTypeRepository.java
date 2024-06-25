package com.binary_dot.ehr_backend.api.ear_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarInfectionTypeRepository extends JpaRepository<EarInfectionType, Integer> {
    List<EarInfectionType> findByName(String name);
}
