package com.binary_dot.ehr_backend.api.drug;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DrugService {
    DrugDto createDrug(DrugDto drugDto);
    DrugDto findById(int id) throws NotFoundException;
    List<DrugDto> findAll(String manufacturerName);
}
