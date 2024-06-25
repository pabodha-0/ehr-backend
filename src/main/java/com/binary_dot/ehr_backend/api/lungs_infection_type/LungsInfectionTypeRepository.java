package com.binary_dot.ehr_backend.api.lungs_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LungsInfectionTypeRepository extends JpaRepository<LungsInfectionType, Integer> {
    List<LungsInfectionType> findByName(String name);
}
