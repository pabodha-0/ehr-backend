package com.binary_dot.ehr_backend.api.other_test_report;

import com.binary_dot.ehr_backend.api.ecg_type.ECGType;
import com.binary_dot.ehr_backend.api.ecg_type.ECGTypeMapper;
import com.binary_dot.ehr_backend.api.ecg_type.ECGTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherTestReportImpl implements OtherTestReportService{
    @Autowired
    private OtherTestReportRepository otherTestReportRepository;

    @Autowired
    private OtherTestReportMapper otherTestReportMapper;

    @Autowired
    private ECGTypeService ecgTypeService;

    @Autowired
    private ECGTypeMapper ecgTypeMapper;

    @Override
    public OtherTestReportDto addOtherTestReport(OtherTestReportDto otherTestReportDto) {
        OtherTestReport otherTestReportEntity = otherTestReportMapper.mapToEntity(otherTestReportDto);

        ECGType ecgType = ecgTypeMapper.mapToEntity(ecgTypeService.createECGType(otherTestReportDto.getEcgType()));
        otherTestReportEntity.setEcgType(ecgType);

        OtherTestReport otherTestReport = otherTestReportRepository.save(otherTestReportEntity);
        return otherTestReportMapper.mapToDto(otherTestReport);
    }
}
