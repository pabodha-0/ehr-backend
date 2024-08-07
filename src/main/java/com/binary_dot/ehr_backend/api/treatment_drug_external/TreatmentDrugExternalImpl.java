package com.binary_dot.ehr_backend.api.treatment_drug_external;

import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyDto;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyService;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentDrugExternalImpl implements TreatmentDrugExternalService {
    @Autowired
    private TreatmentDrugExternalRepository treatmentDrugExternalRepository;

    @Autowired
    private TreatmentDrugExternalMapper treatmentDrugExternalMapper;

    // External Services
    @Autowired
    private DrugIntakeFrequencyService drugIntakeFrequencyService;

    @Override
    public TreatmentDrugExternalDto createExternalTreatmentDrug(TreatmentDrugExternalDto treatmentDrugExternalDto) {
        if(treatmentDrugExternalDto == null) {
            return null;
        }
        DrugIntakeFrequencyDto drugIntakeFrequencyDto = drugIntakeFrequencyService.createDrugIntakeFrequency(treatmentDrugExternalDto.getDrugIntakeFrequency());
        treatmentDrugExternalDto.setDrugIntakeFrequency(drugIntakeFrequencyDto);

        TreatmentDrugExternal treatmentDrugExternal = treatmentDrugExternalRepository.save(treatmentDrugExternalMapper.mapToEntity(treatmentDrugExternalDto));
        return treatmentDrugExternalMapper.mapToDto(treatmentDrugExternal);
    }

    @Override
    public List<TreatmentDrugExternalDto> createExternalTreatmentDrugs(List<TreatmentDrugExternalDto> treatmentDrugExternalDtoList) {
        if(treatmentDrugExternalDtoList == null || treatmentDrugExternalDtoList.isEmpty()){
            return new ArrayList<>();
        }

        List<TreatmentDrugExternalDto> treatmentDrugExternalDtos = new ArrayList<>();
        for (TreatmentDrugExternalDto treatmentDrugExternalDto : treatmentDrugExternalDtoList) {
            treatmentDrugExternalDtos.add(createExternalTreatmentDrug(treatmentDrugExternalDto));
        }

        return treatmentDrugExternalDtos;
    }

    @Override
    public TreatmentDrugExternalDto findById(int id) throws NotFoundException {
        Optional<TreatmentDrugExternal> treatmentDrugExternal = treatmentDrugExternalRepository.findById(id);
        if(treatmentDrugExternal.isPresent()) {
            return treatmentDrugExternalMapper.mapToDto(treatmentDrugExternal.get());
        }

        throw new NotFoundException("External Treatment Drug not found by id: " + id);
    }

    @Override
    public List<TreatmentDrugExternalDto> findAll() {
        List<TreatmentDrugExternal> treatmentDrugExternalList = treatmentDrugExternalRepository.findAll();
        return treatmentDrugExternalList.stream().map(item -> treatmentDrugExternalMapper.mapToDto(item)).toList();
    }
}
