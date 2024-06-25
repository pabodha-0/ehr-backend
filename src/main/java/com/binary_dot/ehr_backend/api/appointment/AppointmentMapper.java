package com.binary_dot.ehr_backend.api.appointment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AppointmentDto mapToDto(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    public Appointment mapToEntity(AppointmentDto appointmentDto) {
        return modelMapper.map(appointmentDto, Appointment.class);
    }
}
