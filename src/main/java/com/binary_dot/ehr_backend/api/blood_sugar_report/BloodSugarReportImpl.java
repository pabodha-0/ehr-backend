package com.binary_dot.ehr_backend.api.blood_sugar_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodSugarReportImpl implements BloodSugarReportService {
    @Autowired
    private BloodSugarReportRepository bloodSugarReportRepository;

    @Autowired
    private BloodSugarReportMapper bloodSugarReportMapper;

    @Override
    public BloodSugarReportDto addBloodSugarReport(BloodSugarReportDto bloodSugarReportDto) {
        BloodSugarReport bloodSugarReport = bloodSugarReportRepository.save(bloodSugarReportMapper.mapToEntity(bloodSugarReportDto));
        return bloodSugarReportMapper.mapToDto(bloodSugarReport);
    }

    @Override
    public BloodSugarReportDto findById(int id) throws NotFoundException {
        Optional<BloodSugarReport> bloodSugarReport = bloodSugarReportRepository.findById(id);
        if (bloodSugarReport.isPresent()) {
            return bloodSugarReportMapper.mapToDto(bloodSugarReport.get());
        }

        throw new NotFoundException("Blood Sugar Report not found by Id: " + id);
    }

    @Override
    public List<BloodSugarReportDto> findAll() {
        List<BloodSugarReport> bloodSugarReportList = bloodSugarReportRepository.findAll();
        return bloodSugarReportList.stream().map(report -> bloodSugarReportMapper.mapToDto(report)).toList();
    }
}
