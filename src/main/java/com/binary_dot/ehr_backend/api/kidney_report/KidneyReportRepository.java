package com.binary_dot.ehr_backend.api.kidney_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidneyReportRepository extends JpaRepository<KidneyReport, Integer> {

}
