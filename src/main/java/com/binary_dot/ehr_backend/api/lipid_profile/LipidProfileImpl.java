package com.binary_dot.ehr_backend.api.lipid_profile;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LipidProfileImpl implements LipidProfileService{
    @Autowired
    private LipidProfileRepository lipidProfileRepository;

    @Autowired
    private LipidProfileMapper lipidProfileMapper;


    @Override
    public LipidProfileDto addLipidProfile(LipidProfileDto lipidProfileDto) {
        LipidProfile lipidProfile = lipidProfileRepository.save(lipidProfileMapper.mapToEntity(lipidProfileDto));
        return lipidProfileMapper.mapToDto(lipidProfile);
    }

    @Override
    public LipidProfileDto findById(int id) throws NotFoundException {
        LipidProfile lipidProfile = lipidProfileRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Lipid profile not found with Id: " + id)
        );
        return lipidProfileMapper.mapToDto(lipidProfile);
    }

    @Override
    public List<LipidProfileDto> findAll() {
        List<LipidProfile> lipidProfiles = lipidProfileRepository.findAll();
        return lipidProfiles.stream().map(profile -> lipidProfileMapper.mapToDto(profile)).toList();
    }
}
