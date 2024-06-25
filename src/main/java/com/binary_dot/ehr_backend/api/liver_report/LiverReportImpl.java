package com.binary_dot.ehr_backend.api.liver_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiverReportImpl implements LiverReportService{
    @Autowired
    private LiverReportRepository liverReportRepository;

    @Autowired
    private LiverReportMapper liverReportMapper;


    @Override
    public LiverReportDto addLiverReport(LiverReportDto liverReportDto) {
        LiverReport liverReport = liverReportRepository.save(liverReportMapper.mapToEntity(liverReportDto));
        return liverReportMapper.mapToDto(liverReport);
    }
}
