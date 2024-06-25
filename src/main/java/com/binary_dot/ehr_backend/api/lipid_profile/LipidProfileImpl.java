package com.binary_dot.ehr_backend.api.lipid_profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
