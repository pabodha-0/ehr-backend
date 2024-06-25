package com.binary_dot.ehr_backend.api.other_test_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherTestReportRepository extends JpaRepository<OtherTestReport, Integer> {

}
