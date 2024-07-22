package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreatmentDrugInternalMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TreatmentDrugInternalDto mapToDto(TreatmentDrugInternal treatmentDrugInternal) {
        return modelMapper.map(treatmentDrugInternal, TreatmentDrugInternalDto.class);
    }

    public TreatmentDrugInternal mapToEntity(TreatmentDrugInternalDto treatmentDrugInternalDto) {
        return modelMapper.map(treatmentDrugInternalDto, TreatmentDrugInternal.class);
    }
}
