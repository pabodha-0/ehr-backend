package com.binary_dot.ehr_backend.api.throat_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThroatInfectionTypeRepository extends JpaRepository<ThroatInfectionType, Integer> {
    List<ThroatInfectionType> findByName(String name);
}
