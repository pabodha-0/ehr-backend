package com.binary_dot.ehr_backend.api.kidney_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KidneyReportImpl implements KidneyReportService{
    @Autowired
    KidneyReportRepository kidneyReportRepository;

    @Autowired
    KidneyReportMapper kidneyReportMapper;


    @Override
    public KidneyReportDto addKidneyReport(KidneyReportDto kidneyReportDto) {
        KidneyReport kidneyReport = kidneyReportRepository.save(kidneyReportMapper.mapToEntity(kidneyReportDto));
        return kidneyReportMapper.mapToDto(kidneyReport);
    }
}
