package com.binary_dot.ehr_backend.api.surgical_history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurgicalHistoryImpl implements SurgicalHistoryService {
    @Autowired
    private SurgicalHistoryRepository surgicalHistoryRepository;

    @Autowired
    private SurgicalHistoryMapper surgicalHistoryMapper;

    @Override
    public SurgicalHistoryDto addSurgicalHistory(SurgicalHistoryDto surgicalHistoryDto) {
        SurgicalHistory surgicalHistory = surgicalHistoryRepository.save(surgicalHistoryMapper.mapToEntity(surgicalHistoryDto));
        return surgicalHistoryMapper.mapToDto(surgicalHistory);
    }
}
