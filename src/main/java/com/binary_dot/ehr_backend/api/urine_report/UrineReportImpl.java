package com.binary_dot.ehr_backend.api.urine_report;

import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureTypeMapper;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureType;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureTypeService;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrineReportImpl implements UrineReportService{
    @Autowired
    private UrineReportRepository urineReportRepository;

    @Autowired
    private UrineReportMapper urineReportMapper;

    @Autowired
    private UrineCultureTypeService urineCultureTypeService;

    @Autowired
    private UrineCultureTypeMapper urineCultureTypeMapper;

    @Override
    public UrineReportDto addUrineReport(UrineReportDto urineReportDto) {
        if(urineReportDto == null) {
            return null;
        }
        UrineReport urineReportEntity = urineReportMapper.mapToEntity(urineReportDto);

        if(urineReportDto.getUrineCultureType() != null) {
            UrineCultureType urineCultureType = urineCultureTypeMapper.mapToEntity(urineCultureTypeService.createUrineCultureType(urineReportDto.getUrineCultureType()));
            urineReportEntity.setUrineCultureType(urineCultureType);
        }

        UrineReport urineReport = urineReportRepository.save(urineReportEntity);
        return urineReportMapper.mapToDto(urineReport);
    }

    @Override
    public UrineReportDto findById(int id) throws NotFoundException {
        UrineReport urineReport = urineReportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found Urine Report by Id: " + id)
        );
        return urineReportMapper.mapToDto(urineReport);
    }

    @Override
    public List<UrineReportDto> findAll() {
        List<UrineReport> urineReports = urineReportRepository.findAll();
        return urineReports.stream().map(report -> urineReportMapper.mapToDto(report)).toList();
    }
}