package com.binary_dot.ehr_backend.api.drug;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfo;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturer;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugImpl implements DrugService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    DrugMapper drugMapper;

    @Override
    public DrugDto createDrug(DrugDto drugDto) {
        if(drugDto == null) {
            return null;
        }
        List<Drug> existingDrug = drugRepository.findByName(drugDto.getName());
        if (existingDrug.isEmpty()) {
            Drug drug = drugRepository.save(drugMapper.mapToEntity(drugDto));
            return drugMapper.mapToDto(drug);
        }

        return drugMapper.mapToDto(existingDrug.getFirst());
    }

    @Override
    public DrugDto findById(int id) throws NotFoundException {
        Optional<Drug> drug = drugRepository.findById(id);
        if(drug.isPresent()) {
            return drugMapper.mapToDto(drug.get());
        }

        throw new NotFoundException("Drug not found by id: " + id);
    }

    @Override
    public List<DrugDto> findAll(String manufacturerName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Drug> criteriaQuery = criteriaBuilder.createQuery(Drug.class);
        Root<Drug> drugRoot = criteriaQuery.from(Drug.class);

        Join<Drug, DrugInfo> drugInfoJoin = drugRoot.join("drugInfoList");
        Join<DrugInfo, DrugManufacturer> drugManufacturerJoin = drugInfoJoin.join("drugManufacturer");

        List<Predicate> predicates = new ArrayList<>();

        if (manufacturerName != null && !manufacturerName.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugManufacturerJoin.get("name"), manufacturerName));
        }

        criteriaQuery.select(drugRoot).where(predicates.toArray(new Predicate[0]));
        List<Drug> drugs = entityManager.createQuery(criteriaQuery).getResultList();

        return drugs.stream().map(drug -> drugMapper.mapToDto(drug)).toList();
    }

}
