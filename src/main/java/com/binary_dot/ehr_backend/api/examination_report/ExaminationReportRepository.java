package com.binary_dot.ehr_backend.api.examination_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationReportRepository extends JpaRepository<ExaminationReport, Integer> {

}
