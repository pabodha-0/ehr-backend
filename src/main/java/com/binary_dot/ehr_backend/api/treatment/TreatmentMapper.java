package com.binary_dot.ehr_backend.api.treatment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreatmentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TreatmentDto mapToDto(Treatment treatment) {
        return modelMapper.map(treatment, TreatmentDto.class);
    }

    public Treatment mapToEntity(TreatmentDto treatmentDto) {
        return modelMapper.map(treatmentDto, Treatment.class);
    }
}
