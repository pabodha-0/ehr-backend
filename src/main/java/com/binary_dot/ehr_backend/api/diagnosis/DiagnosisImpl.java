package com.binary_dot.ehr_backend.api.diagnosis;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisImpl implements DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Override
    public DiagnosisDto createDiagnosis(DiagnosisDto diagnosisDto) {
        List<Diagnosis> existingDiagnosis = diagnosisRepository.findByName(diagnosisDto.getName());
        if (existingDiagnosis.isEmpty()) {
            Diagnosis diagnosis = diagnosisRepository.save(diagnosisMapper.mapToEntity(diagnosisDto));
            return diagnosisMapper.mapToDto(diagnosis);
        }

        return diagnosisMapper.mapToDto(existingDiagnosis.getFirst());
    }

    @Override
    public List<DiagnosisDto> createDiagnoses(List<DiagnosisDto> diagnosisDtoList) {
        if(diagnosisDtoList == null || diagnosisDtoList.isEmpty()){
            return new ArrayList<>();
        }

        List<DiagnosisDto> diagnoses = new ArrayList<>();
        for (DiagnosisDto diagnosisDto : diagnosisDtoList) {
            diagnoses.add(createDiagnosis(diagnosisDto));
        }

        return diagnoses;
    }

    @Override
    public DiagnosisDto findById(int id) throws NotFoundException{
        Optional<Diagnosis> diagnosis = diagnosisRepository.findById(id);
        if(diagnosis.isPresent()) {
            return diagnosisMapper.mapToDto(diagnosis.get());
        }

        throw new NotFoundException("Diagnosis not found by Id: " + id);
    }

    @Override
    public List<DiagnosisDto> findAll() {
        List<Diagnosis> diagnoses = diagnosisRepository.findAll();
        return diagnoses.stream().map(diagnosis -> diagnosisMapper.mapToDto(diagnosis)).toList();
    }
}
