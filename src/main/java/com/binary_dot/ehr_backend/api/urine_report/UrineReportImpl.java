package com.binary_dot.ehr_backend.api.urine_report;

import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureTypeMapper;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureType;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        UrineReport urineReportEntity = urineReportMapper.mapToEntity(urineReportDto);

        UrineCultureType urineCultureType = urineCultureTypeMapper.mapToEntity(urineCultureTypeService.createUrineCultureType(urineReportDto.getUrineCultureType()));
        urineReportEntity.setUrineCultureType(urineCultureType);

        UrineReport urineReport = urineReportRepository.save(urineReportEntity);
        return urineReportMapper.mapToDto(urineReport);
    }
}