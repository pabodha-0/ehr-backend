package com.binary_dot.ehr_backend.api.drug_manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugManufacturerRepository extends JpaRepository<DrugManufacturer, Integer> {

}
