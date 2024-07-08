package com.binary_dot.ehr_backend.api.examination_report;

import com.binary_dot.ehr_backend.api.abdomen_infection_type.AbdomenInfectionType;
import com.binary_dot.ehr_backend.api.abdomen_infection_type.AbdomenInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.abdomen_infection_type.AbdomenInfectionTypeService;
import com.binary_dot.ehr_backend.api.ear_infection_type.EarInfectionType;
import com.binary_dot.ehr_backend.api.ear_infection_type.EarInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.ear_infection_type.EarInfectionTypeService;
import com.binary_dot.ehr_backend.api.heart_rhythm_type.HeartRhythmType;
import com.binary_dot.ehr_backend.api.heart_rhythm_type.HeartRhythmTypeMapper;
import com.binary_dot.ehr_backend.api.heart_rhythm_type.HeartRhythmTypeService;
import com.binary_dot.ehr_backend.api.heart_sound_type.HeartSoundType;
import com.binary_dot.ehr_backend.api.heart_sound_type.HeartSoundTypeMapper;
import com.binary_dot.ehr_backend.api.heart_sound_type.HeartSoundTypeService;
import com.binary_dot.ehr_backend.api.lungs_infection_type.LungsInfectionType;
import com.binary_dot.ehr_backend.api.lungs_infection_type.LungsInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.lungs_infection_type.LungsInfectionTypeService;
import com.binary_dot.ehr_backend.api.lymph_node_infection_type.LymphNodeInfectionType;
import com.binary_dot.ehr_backend.api.lymph_node_infection_type.LymphNodeInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.lymph_node_infection_type.LymphNodeInfectionTypeService;
import com.binary_dot.ehr_backend.api.nose_infection_type.NoseInfectionType;
import com.binary_dot.ehr_backend.api.nose_infection_type.NoseInfectionTypeService;
import com.binary_dot.ehr_backend.api.nose_infection_type.NoseInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.throat_infection_type.ThroatInfectionType;
import com.binary_dot.ehr_backend.api.throat_infection_type.ThroatInfectionTypeMapper;
import com.binary_dot.ehr_backend.api.throat_infection_type.ThroatInfectionTypeService;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationReportImpl implements ExaminationReportService{
    @Autowired
    private ExaminationReportRepository examinationReportRepository;

    @Autowired
    private ExaminationReportMapper examinationReportMapper;

    // External Services
    @Autowired
    private EarInfectionTypeService earInfectionTypeService;

    @Autowired
    private NoseInfectionTypeService noseInfectionService;

    @Autowired
    private ThroatInfectionTypeService throatInfectionTypeService;

    @Autowired
    private AbdomenInfectionTypeService abdomenInfectionTypeService;

    @Autowired
    private LymphNodeInfectionTypeService lymphNodeInfectionTypeService;

    @Autowired
    private LungsInfectionTypeService lungsInfectionTypeService;

    @Autowired
    private HeartSoundTypeService heartSoundTypeService;

    @Autowired
    private HeartRhythmTypeService heartRhythmTypeService;

    // External Mappers
    @Autowired
    private EarInfectionTypeMapper earInfectionTypeMapper;

    @Autowired
    private NoseInfectionTypeMapper noseInfectionTypeMapper;

    @Autowired
    private ThroatInfectionTypeMapper throatInfectionTypeMapper;

    @Autowired
    private AbdomenInfectionTypeMapper abdomenInfectionTypeMapper;

    @Autowired
    private LymphNodeInfectionTypeMapper lymphNodeInfectionTypeMapper;

    @Autowired
    private LungsInfectionTypeMapper lungsInfectionTypeMapper;

    @Autowired
    private HeartSoundTypeMapper heartSoundTypeMapper;

    @Autowired
    private HeartRhythmTypeMapper heartRhythmTypeMapper;

    @Override
    public ExaminationReportDto createExaminationReport(ExaminationReportDto examinationReportDto) {
        ExaminationReport examinationReportEntity = examinationReportMapper.mapToEntity(examinationReportDto);

        EarInfectionType earInfectionType = earInfectionTypeMapper.mapToEntity(earInfectionTypeService.addEarInfectionType(examinationReportDto.getEarInfectionType()));
        NoseInfectionType noseInfectionType = noseInfectionTypeMapper.mapToEntity(noseInfectionService.addNoseInfectionType(examinationReportDto.getNoseInfectionType()));
        ThroatInfectionType throatInfectionType = throatInfectionTypeMapper.mapToEntity(throatInfectionTypeService.addThroatInfectionType(examinationReportDto.getThroatInfectionType()));
        AbdomenInfectionType abdomenInfectionType = abdomenInfectionTypeMapper.mapToEntity(abdomenInfectionTypeService.addAbdomenInfectionType(examinationReportDto.getAbdomenInfectionType()));
        LymphNodeInfectionType lymphNodeInfectionType = lymphNodeInfectionTypeMapper.mapToEntity(lymphNodeInfectionTypeService.addLymphNodeInfectionType(examinationReportDto.getLymphNodeInfectionType()));
        LungsInfectionType lungsInfectionType = lungsInfectionTypeMapper.mapToEntity(lungsInfectionTypeService.addLungsInfectionType(examinationReportDto.getLungsInfectionType()));
        HeartSoundType heartSoundType = heartSoundTypeMapper.mapToEntity(heartSoundTypeService.addHeartSoundType(examinationReportDto.getHeartSoundType()));
        HeartRhythmType heartRhythmType = heartRhythmTypeMapper.mapToEntity(heartRhythmTypeService.addHeartRhythmType(examinationReportDto.getHeartRhythmType()));

        examinationReportEntity.setEarInfectionType(earInfectionType);
        examinationReportEntity.setNoseInfectionType(noseInfectionType);
        examinationReportEntity.setThroatInfectionType(throatInfectionType);
        examinationReportEntity.setAbdomenInfectionType(abdomenInfectionType);
        examinationReportEntity.setLymphNodeInfectionType(lymphNodeInfectionType);
        examinationReportEntity.setLungsInfectionType(lungsInfectionType);
        examinationReportEntity.setHeartSoundType(heartSoundType);
        examinationReportEntity.setHeartRhythmType(heartRhythmType);

        ExaminationReport examinationReport = examinationReportRepository.save(examinationReportEntity);
        return examinationReportMapper.mapToDto(examinationReport);
    }

    @Override
    public ExaminationReportDto findById(int id) throws NotFoundException {
        ExaminationReport examinationReport = examinationReportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Examination report not found by Id: " + id)
        );
        return examinationReportMapper.mapToDto(examinationReport);
    }

    @Override
    public List<ExaminationReportDto> findAll() {
        List<ExaminationReport> examinationReports = examinationReportRepository.findAll();
        return examinationReports.stream().map(report -> examinationReportMapper.mapToDto(report)).toList();
    }
}
