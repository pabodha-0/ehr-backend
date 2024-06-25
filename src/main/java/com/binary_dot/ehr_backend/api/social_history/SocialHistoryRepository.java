package com.binary_dot.ehr_backend.api.social_history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialHistoryRepository extends JpaRepository<SocialHistory, Integer> {

}
