package com.binary_dot.ehr_backend.api.social_history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialHistoryImpl implements SocialHistoryService {
    @Autowired
    SocialHistoryRepository socialHistoryRepository;

    @Autowired
    SocialHistoryMapper socialHistoryMapper;

    @Override
    public SocialHistoryDto addSocialHistory(SocialHistoryDto socialHistoryDto) {
        SocialHistory socialHistory = socialHistoryRepository.save(socialHistoryMapper.mapToEntity(socialHistoryDto));
        return socialHistoryMapper.mapToDto(socialHistory);
    }
}
