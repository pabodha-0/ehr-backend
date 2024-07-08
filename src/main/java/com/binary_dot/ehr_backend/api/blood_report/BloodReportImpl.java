package com.binary_dot.ehr_backend.api.blood_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodReportImpl implements BloodReportService{
    @Autowired
    private BloodReportRepository bloodReportRepository;

    @Autowired
    private BloodReportMapper bloodReportMapper;

    @Override
    public BloodReportDto addBloodReport(BloodReportDto bloodReportDto) {
        BloodReport bloodReport = bloodReportRepository.save(bloodReportMapper.mapToEntity(bloodReportDto));
        return bloodReportMapper.mapToDto(bloodReport);
    }

    @Override
    public BloodReportDto findById(int id) throws NotFoundException{
        Optional<BloodReport> bloodReport = bloodReportRepository.findById(id);
        if (bloodReport.isPresent()) {
            return bloodReportMapper.mapToDto(bloodReport.get());
        }

        throw new NotFoundException("Blood Report Not Found By Id: " + id);
    }

    @Override
    public List<BloodReportDto> getAllBloodReports() {
        List<BloodReport> bloodReports = bloodReportRepository.findAll();
        return bloodReports.stream().map(report -> bloodReportMapper.mapToDto(report)).toList();
    }
}
