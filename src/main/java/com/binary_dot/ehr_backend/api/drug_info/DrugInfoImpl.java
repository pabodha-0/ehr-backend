package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.api.drug.Drug;
import com.binary_dot.ehr_backend.api.drug.DrugDto;
import com.binary_dot.ehr_backend.api.drug.DrugMapper;
import com.binary_dot.ehr_backend.api.drug.DrugService;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturer;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturerDto;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturerMapper;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturerService;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugInfoImpl implements DrugInfoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    DrugInfoRepository drugInfoRepository;

    @Autowired
    DrugInfoMapper drugInfoMapper;

    // External Services
    @Autowired
    DrugService drugService;

    @Autowired
    DrugManufacturerService drugManufacturerService;

    // External Mappers
    @Autowired
    DrugMapper drugMapper;

    @Autowired
    DrugManufacturerMapper drugManufacturerMapper;


    @Override
    public DrugInfoDto createDrugInfo(DrugInfoDto drugInfoDto) {
        if(drugInfoDto == null) {
            return null;
        }
        DrugDto drugDto = drugService.createDrug(drugInfoDto.getDrug());
        DrugManufacturerDto drugManufacturerDto = drugManufacturerService.createDrugManufacturer(drugInfoDto.getDrugManufacturer());

        drugInfoDto.setDrug(drugDto);
        drugInfoDto.setDrugManufacturer(drugManufacturerDto);

        DrugInfo drugInfo = drugInfoRepository.save(drugInfoMapper.mapToEntity(drugInfoDto));
        return drugInfoMapper.mapToDto(drugInfo);
    }

    @Override
    public DrugInfoDto findById(int id) throws NotFoundException {
        Optional<DrugInfo> drugInfo = drugInfoRepository.findById(id);
        if(drugInfo.isPresent()) {
            return drugInfoMapper.mapToDto(drugInfo.get());
        }

        throw new NotFoundException("Drug Info not found by id: " + id);
    }

    @Override
    public List<DrugInfoDto> findAll(String drugName, String manufacturerName, String drugDosage, String drugExpDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DrugInfo> criteriaQuery = criteriaBuilder.createQuery(DrugInfo.class);
        Root<DrugInfo> drugInfoRoot = criteriaQuery.from(DrugInfo.class);

        Join<DrugInfo, Drug> drugJoin = drugInfoRoot.join("drug");
        Join<DrugInfo, DrugManufacturer> drugManufacturerJoin = drugInfoRoot.join("drugManufacturer");

        List<Predicate> predicates = new ArrayList<>();

        if (drugName != null && !drugName.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugJoin.get("name"), drugName));
        }

        if (manufacturerName != null && !manufacturerName.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugManufacturerJoin.get("name"), manufacturerName));
        }
        if (drugDosage != null && !drugDosage.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugInfoRoot.get("dosage"), drugDosage));
        }
        if (drugExpDate != null && !drugExpDate.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugInfoRoot.get("expDate"), drugExpDate));
        }

        criteriaQuery.select(drugInfoRoot).where(predicates.toArray(new Predicate[0]));
        List<DrugInfo> drugInfoList = entityManager.createQuery(criteriaQuery).getResultList();

        return drugInfoList.stream().map(drugInfo -> drugInfoMapper.mapToDto(drugInfo)).toList();
    }
}
