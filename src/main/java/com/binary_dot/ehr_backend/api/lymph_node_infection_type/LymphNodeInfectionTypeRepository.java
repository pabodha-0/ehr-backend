package com.binary_dot.ehr_backend.api.lymph_node_infection_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LymphNodeInfectionTypeRepository extends JpaRepository<LymphNodeInfectionType, Integer> {
    List<LymphNodeInfectionType> findByName(String name);
}
