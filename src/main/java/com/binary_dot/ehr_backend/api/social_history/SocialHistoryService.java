package com.binary_dot.ehr_backend.api.social_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface SocialHistoryService {
    SocialHistoryDto addSocialHistory(SocialHistoryDto socialHistoryDto);
    SocialHistoryDto findById(int id) throws NotFoundException;
    List<SocialHistoryDto> findAll();
}
