package com.binary_dot.ehr_backend.api.kidney_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KidneyReportImpl implements KidneyReportService{
    @Autowired
    KidneyReportRepository kidneyReportRepository;

    @Autowired
    KidneyReportMapper kidneyReportMapper;


    @Override
    public KidneyReportDto addKidneyReport(KidneyReportDto kidneyReportDto) {
        if(kidneyReportDto == null) {
            return null;
        }
        KidneyReport kidneyReport = kidneyReportRepository.save(kidneyReportMapper.mapToEntity(kidneyReportDto));
        return kidneyReportMapper.mapToDto(kidneyReport);
    }

    @Override
    public KidneyReportDto findById(int id) throws NotFoundException {
        KidneyReport kidneyReport = kidneyReportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Kidney report not found with Id: " + id)
        );
        return kidneyReportMapper.mapToDto(kidneyReport);
    }

    @Override
    public List<KidneyReportDto> findAll() {
        List<KidneyReport> kidneyReports = kidneyReportRepository.findAll();
        return kidneyReports.stream().map(report -> kidneyReportMapper.mapToDto(report)).toList();
    }
}
