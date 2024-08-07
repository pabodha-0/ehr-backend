package com.binary_dot.ehr_backend.api.treatment_drug_internal;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfoDto;
import com.binary_dot.ehr_backend.api.drug_info.DrugInfoService;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyDto;
import com.binary_dot.ehr_backend.api.drug_intake_frequency.DrugIntakeFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentDrugInternalImpl implements TreatmentDrugInternalService{
    @Autowired
    private TreatmentDrugInternalRepository treatmentDrugInternalRepository;

    @Autowired
    private TreatmentDrugInternalMapper treatmentDrugInternalMapper;

    // External Services
    @Autowired
    private DrugIntakeFrequencyService drugIntakeFrequencyService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Override
    public TreatmentDrugInternalDto createTreatmentDrugInternal(TreatmentDrugInternalDto treatmentDrugInternalDto) {
        if(treatmentDrugInternalDto == null) {
            return null;
        }
        DrugIntakeFrequencyDto drugIntakeFrequencyDto = drugIntakeFrequencyService.createDrugIntakeFrequency(treatmentDrugInternalDto.getDrugIntakeFrequency());
//        DrugInfoDto drugInfoDto = drugInfoService.createDrugInfo(treatmentDrugInternalDto.getDrugInfo());
        DrugInfoDto drugInfoDto = drugInfoService.findAll(
                treatmentDrugInternalDto.getDrugInfo().getDrug().getName(),
                treatmentDrugInternalDto.getDrugInfo().getDrugManufacturer().getName(),
                treatmentDrugInternalDto.getDrugInfo().getDosage(),
                treatmentDrugInternalDto.getDrugInfo().getExpDate()
        ).getFirst();

//        handle drug info not found

        treatmentDrugInternalDto.setDrugIntakeFrequency(drugIntakeFrequencyDto);
        treatmentDrugInternalDto.setDrugInfo(drugInfoDto);

        TreatmentDrugInternal treatmentDrugInternal = treatmentDrugInternalRepository.save(treatmentDrugInternalMapper.mapToEntity(treatmentDrugInternalDto));
        return treatmentDrugInternalMapper.mapToDto(treatmentDrugInternal);
    }

    @Override
    public TreatmentDrugInternalDto findAllByDrugInfoId(int id) {
        return null;
    }

    @Override
    public TreatmentDrugInternalDto findAllByTreatmentId(int id) {
        return null;
    }

    @Override
    public List<TreatmentDrugInternalDto> findAll() {
        List<TreatmentDrugInternal> treatmentDrugInternalList = treatmentDrugInternalRepository.findAll();
        return treatmentDrugInternalList.stream().map(item -> treatmentDrugInternalMapper.mapToDto(item)).toList();
    }
}
