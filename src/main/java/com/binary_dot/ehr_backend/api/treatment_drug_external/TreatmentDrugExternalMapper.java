package com.binary_dot.ehr_backend.api.treatment_drug_external;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreatmentDrugExternalMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TreatmentDrugExternalDto mapToDto(TreatmentDrugExternal treatmentDrugExternal) {
        return modelMapper.map(treatmentDrugExternal, TreatmentDrugExternalDto.class);
    }

    public TreatmentDrugExternal mapToEntity(TreatmentDrugExternalDto treatmentDrugExternalDto) {
        return modelMapper.map(treatmentDrugExternalDto, TreatmentDrugExternal.class);
    }
}
