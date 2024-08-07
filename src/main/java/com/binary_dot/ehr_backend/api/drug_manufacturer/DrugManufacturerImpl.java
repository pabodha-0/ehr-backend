package com.binary_dot.ehr_backend.api.drug_manufacturer;

import com.binary_dot.ehr_backend.api.drug.Drug;
import com.binary_dot.ehr_backend.api.drug_info.DrugInfo;
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
public class DrugManufacturerImpl implements DrugManufacturerService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    DrugManufacturerRepository drugManufacturerRepository;

    @Autowired
    DrugManufacturerMapper drugManufacturerMapper;

    @Override
    public DrugManufacturerDto createDrugManufacturer(DrugManufacturerDto drugManufacturerDto) {
        if(drugManufacturerDto == null) {
            return null;
        }
        List<DrugManufacturer> existingDrugManufacturers = drugManufacturerRepository.findByName(drugManufacturerDto.getName());
        if (existingDrugManufacturers.isEmpty()) {
            DrugManufacturer drugManufacturer = drugManufacturerRepository.save(drugManufacturerMapper.mapToEntity(drugManufacturerDto));
            return drugManufacturerMapper.mapToDto(drugManufacturer);
        }

        return drugManufacturerMapper.mapToDto(existingDrugManufacturers.getFirst());
    }

    @Override
    public DrugManufacturerDto findById(int id) throws NotFoundException {
        Optional<DrugManufacturer> drugManufacturer = drugManufacturerRepository.findById(id);
        if(drugManufacturer.isPresent()) {
            return drugManufacturerMapper.mapToDto(drugManufacturer.get());
        }

        throw new NotFoundException("Drug Manufacturer not found by id: " + id);
    }

    @Override
    public List<DrugManufacturerDto> findAll(String drugName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DrugManufacturer> criteriaQuery = criteriaBuilder.createQuery(DrugManufacturer.class);
        Root<DrugManufacturer> drugManufacturerRoot = criteriaQuery.from(DrugManufacturer.class);

        Join<DrugManufacturer, DrugInfo> drugInfoJoin = drugManufacturerRoot.join("drugInfoList");
        Join<DrugInfo, Drug> drugJoin = drugInfoJoin.join("drug");

        List<Predicate> predicates = new ArrayList<>();

        if (drugName != null && !drugName.isEmpty()) {
            predicates.add(criteriaBuilder.equal(drugJoin.get("name"), drugName));
        }

        criteriaQuery.select(drugManufacturerRoot).where(predicates.toArray(new Predicate[0]));
        List<DrugManufacturer> drugManufacturers = entityManager.createQuery(criteriaQuery).getResultList();

        return drugManufacturers.stream().map(manufacturer -> drugManufacturerMapper.mapToDto(manufacturer)).toList();

    }
}
