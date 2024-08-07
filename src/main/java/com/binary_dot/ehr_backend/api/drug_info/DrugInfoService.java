package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface DrugInfoService {
    DrugInfoDto createDrugInfo(DrugInfoDto drugInfoDto);
    DrugInfoDto findById(int id) throws NotFoundException;
    List<DrugInfoDto> findAll(String drugName, String manufacturerName, String drugDosage, String drugExpDate);
}
