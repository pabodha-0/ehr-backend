package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.exception.NotFoundException;

public interface AppointmentService {
    AppointmentDto addEntry(AppointmentDto appointmentDto);
    AppointmentDto findById(int id) throws NotFoundException;
}
