package com.binary_dot.ehr_backend.api.lipid_profile;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface LipidProfileService {
    LipidProfileDto addLipidProfile(LipidProfileDto lipidProfileDto);
    LipidProfileDto findById(int id) throws NotFoundException;
    List<LipidProfileDto> findAll();
}
