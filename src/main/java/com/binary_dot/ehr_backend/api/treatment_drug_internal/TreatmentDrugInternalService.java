package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import java.util.List;

public interface TreatmentDrugInternalService {
    TreatmentDrugInternalDto createTreatmentDrugInternal(TreatmentDrugInternalDto treatmentDrugInternalDto);
    TreatmentDrugInternalDto findAllByDrugInfoId(int id);
    TreatmentDrugInternalDto findAllByTreatmentId(int id);
    List<TreatmentDrugInternalDto> findAll();
}
