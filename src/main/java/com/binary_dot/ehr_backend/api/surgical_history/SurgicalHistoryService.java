package com.binary_dot.ehr_backend.api.surgical_history;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface SurgicalHistoryService {
    SurgicalHistoryDto addSurgicalHistory(SurgicalHistoryDto surgicalHistoryDto);
    SurgicalHistoryDto findById(int id) throws NotFoundException;
    List<SurgicalHistoryDto> findAll();
}
