package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.exception.NotFoundException;

import java.util.List;

public interface AppointmentService {
    AppointmentDto addEntry(AppointmentDto appointmentDto);
    List<AppointmentDto> findAll();
    AppointmentDto findById(int id) throws NotFoundException;
}
