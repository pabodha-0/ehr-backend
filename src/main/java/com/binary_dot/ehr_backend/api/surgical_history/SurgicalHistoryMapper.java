package com.binary_dot.ehr_backend.api.surgical_history;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurgicalHistoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SurgicalHistoryDto mapToDto(SurgicalHistory surgicalHistory) {
        return modelMapper.map(surgicalHistory, SurgicalHistoryDto.class);
    }

    public SurgicalHistory mapToEntity(SurgicalHistoryDto surgicalHistoryDto) {
        return modelMapper.map(surgicalHistoryDto, SurgicalHistory.class);
    }
}
