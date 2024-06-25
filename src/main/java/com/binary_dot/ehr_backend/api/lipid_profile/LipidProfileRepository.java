package com.binary_dot.ehr_backend.api.lipid_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LipidProfileRepository extends JpaRepository<LipidProfile, Integer> {

}
