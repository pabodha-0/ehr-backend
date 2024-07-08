package com.binary_dot.ehr_backend.api.surgical_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public SurgicalHistoryDto findById(int id) throws NotFoundException {
        SurgicalHistory surgicalHistory = surgicalHistoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Surgical History not found by Id: " + id)
        );
        return surgicalHistoryMapper.mapToDto(surgicalHistory);
    }

    @Override
    public List<SurgicalHistoryDto> findAll() {
        List<SurgicalHistory> surgicalHistories = surgicalHistoryRepository.findAll();
        return surgicalHistories.stream().map(history -> surgicalHistoryMapper.mapToDto(history)).toList();
    }
}
