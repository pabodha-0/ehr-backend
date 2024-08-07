package com.binary_dot.ehr_backend.api.drug_manufacturer;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DrugManufacturerService {
    DrugManufacturerDto createDrugManufacturer(DrugManufacturerDto drugManufacturerDto);
    DrugManufacturerDto findById(int id) throws NotFoundException;
    List<DrugManufacturerDto> findAll(String drugName);
}
