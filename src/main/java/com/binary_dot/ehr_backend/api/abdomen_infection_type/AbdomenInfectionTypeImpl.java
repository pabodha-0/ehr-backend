package com.binary_dot.ehr_backend.api.abdomen_infection_type;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AbdomenInfectionTypeImpl implements AbdomenInfectionTypeService {
    @Autowired
    private AbdomenInfectionTypeMapper abdomenInfectionTypeMapper;

    @Autowired
    AbdomenInfectionTypeRepository abdomenInfectionTypeRepository;

    @Override
    public AbdomenInfectionTypeDto addAbdomenInfectionType(AbdomenInfectionTypeDto abdomenInfectionTypeDto) {
        if (abdomenInfectionTypeDto.getName() != null && !abdomenInfectionTypeDto.getName().isEmpty()) {
            List<AbdomenInfectionType> existingAbdomenInfectionType = abdomenInfectionTypeRepository.findByName(abdomenInfectionTypeDto.getName());
            if (existingAbdomenInfectionType.isEmpty()) {
                AbdomenInfectionType abdomenInfectionType = abdomenInfectionTypeRepository.save(abdomenInfectionTypeMapper.mapToEntity(abdomenInfectionTypeDto));
                return abdomenInfectionTypeMapper.mapToDto(abdomenInfectionType);
            }

            return abdomenInfectionTypeMapper.mapToDto(existingAbdomenInfectionType.getFirst());

        } else return null;
    }

    @Override
    public List<AbdomenInfectionTypeDto> findAll() {
        List<AbdomenInfectionType> abdomenInfectionTypes = abdomenInfectionTypeRepository.findAll();
        return abdomenInfectionTypes.stream().map((k) -> abdomenInfectionTypeMapper.mapToDto(k)).toList();
    }

    @Override
    public AbdomenInfectionTypeDto findById(int id) throws NotFoundException {
        AbdomenInfectionType abdomenInfectionType = abdomenInfectionTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found Abdomen Infection Type with id: " + id)
        );
        return abdomenInfectionTypeMapper.mapToDto(abdomenInfectionType);
    }
}
