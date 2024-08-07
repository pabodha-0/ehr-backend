package com.binary_dot.ehr_backend.api.drug_manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugManufacturerRepository extends JpaRepository<DrugManufacturer, Integer> {
    List<DrugManufacturer> findByName(String name);
}
