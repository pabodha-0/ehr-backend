package com.binary_dot.ehr_backend.api.appointment_symptom;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentSymptomMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AppointmentSymptomDto mapToDto(AppointmentSymptom appointmentSymptom) {return modelMapper.map(appointmentSymptom, AppointmentSymptomDto.class);}

    public AppointmentSymptom mapToEntity(AppointmentSymptomDto appointmentSymptomDto) {return modelMapper.map(appointmentSymptomDto, AppointmentSymptom.class);}
}
