package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbdomenInfectionTypeImpl implements AbdomenInfectionTypeService {
    @Autowired
    private AbdomenInfectionTypeMapper abdomenInfectionTypeMapper;

    @Autowired
    AbdomenInfectionTypeRepository abdomenInfectionTypeRepository;

    @Override
    public AbdomenInfectionTypeDto addAbdomenInfectionType(AbdomenInfectionTypeDto abdomenInfectionTypeDto) {
        List<AbdomenInfectionType> existingAbdomenInfectionType = abdomenInfectionTypeRepository.findByName(abdomenInfectionTypeDto.getName());
        if (existingAbdomenInfectionType.isEmpty()) {
            AbdomenInfectionType abdomenInfectionType = abdomenInfectionTypeRepository.save(abdomenInfectionTypeMapper.mapToEntity(abdomenInfectionTypeDto));
            return abdomenInfectionTypeMapper.mapToDto(abdomenInfectionType);
        }

        return abdomenInfectionTypeMapper.mapToDto(existingAbdomenInfectionType.getFirst());
    }

    @Override
    public List<AbdomenInfectionTypeDto> findAll() {
        List<AbdomenInfectionType> abdomenInfectionTypes = abdomenInfectionTypeRepository.findAll();
        return abdomenInfectionTypes.stream().map((k) -> abdomenInfectionTypeMapper.mapToDto(k)).toList();
    }

    @Override
    public ResponseEntity<AbdomenInfectionTypeDto> findById(int id) throws NotFoundException {
        Optional<AbdomenInfectionType> abdomenInfectionType = abdomenInfectionTypeRepository.findById(id);
        if (abdomenInfectionType.isPresent()) {
            return ResponseEntity.ok(abdomenInfectionTypeMapper.mapToDto(abdomenInfectionType.get()));
        }

        throw new NotFoundException("Abdomen Infection Type Not Found By Id: " + id);
    }
}
