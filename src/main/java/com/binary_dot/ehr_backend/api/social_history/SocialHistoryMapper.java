package com.binary_dot.ehr_backend.api.social_history;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocialHistoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SocialHistoryDto mapToDto(SocialHistory socialHistory) {
        return modelMapper.map(socialHistory, SocialHistoryDto.class);
    }

    public SocialHistory mapToEntity(SocialHistoryDto socialHistoryDto) {
        return modelMapper.map(socialHistoryDto, SocialHistory.class);
    }
}
