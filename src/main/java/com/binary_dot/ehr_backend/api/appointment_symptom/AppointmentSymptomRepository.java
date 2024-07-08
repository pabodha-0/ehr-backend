package com.binary_dot.ehr_backend.api.appointment_symptom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentSymptomRepository extends JpaRepository<AppointmentSymptom, AppointmentSymptomId> {
    List<AppointmentSymptom> findBySymptomId(int id);
    List<AppointmentSymptom> findByAppointmentId(int id);
}
