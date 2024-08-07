package com.binary_dot.ehr_backend.api.social_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialHistoryImpl implements SocialHistoryService {
    @Autowired
    SocialHistoryRepository socialHistoryRepository;

    @Autowired
    SocialHistoryMapper socialHistoryMapper;

    @Override
    public SocialHistoryDto addSocialHistory(SocialHistoryDto socialHistoryDto) {
        if(socialHistoryDto == null) {
            return null;
        }
        SocialHistory socialHistory = socialHistoryRepository.save(socialHistoryMapper.mapToEntity(socialHistoryDto));
        return socialHistoryMapper.mapToDto(socialHistory);
    }

    @Override
    public SocialHistoryDto findById(int id) throws NotFoundException {
        SocialHistory socialHistory = socialHistoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Social History not found by Id: " + id)
        );
        return socialHistoryMapper.mapToDto(socialHistory);
    }

    @Override
    public List<SocialHistoryDto> findAll() {
        List<SocialHistory> socialHistories = socialHistoryRepository.findAll();
        return socialHistories.stream().map(history -> socialHistoryMapper.mapToDto(history)).toList();
    }
}
