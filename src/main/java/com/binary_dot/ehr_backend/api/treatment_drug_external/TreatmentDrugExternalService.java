package com.binary_dot.ehr_backend.api.treatment_drug_external;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface TreatmentDrugExternalService {
    TreatmentDrugExternalDto createExternalTreatmentDrug(TreatmentDrugExternalDto treatmentDrugExternalDto);
    List<TreatmentDrugExternalDto> createExternalTreatmentDrugs(List<TreatmentDrugExternalDto> treatmentDrugExternalDtoList);
    TreatmentDrugExternalDto findById(int id) throws NotFoundException;
    List<TreatmentDrugExternalDto> findAll();
}
