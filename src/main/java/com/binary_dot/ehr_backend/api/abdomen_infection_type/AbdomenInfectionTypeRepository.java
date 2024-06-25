package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbdomenInfectionTypeRepository extends JpaRepository<AbdomenInfectionType, Integer> {
    List<AbdomenInfectionType> findByName(String name);
}
