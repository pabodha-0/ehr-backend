package com.binary_dot.ehr_backend.api.appointment_symptom;

import java.util.List;

public interface AppointmentSymptomService {
    AppointmentSymptomDto createAppointmentSymptom(AppointmentSymptomDto appointmentSymptomDto);
    List<AppointmentSymptomDto> findAllByAppointmentId(int id);
    List<AppointmentSymptomDto> findAllBySymptomId(int id);
    List<AppointmentSymptomDto> findAll();
}
