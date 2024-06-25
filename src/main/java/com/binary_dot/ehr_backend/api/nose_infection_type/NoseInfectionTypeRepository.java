package com.binary_dot.ehr_backend.api.nose_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoseInfectionTypeRepository extends JpaRepository<NoseInfectionType, Integer> {
    List<NoseInfectionType> findByName(String name);
}
