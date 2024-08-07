package com.binary_dot.ehr_backend.api.appointment_symptom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentSymptomImpl implements AppointmentSymptomService {
    @Autowired
    private AppointmentSymptomRepository appointmentSymptomRepository;

    @Autowired
    private AppointmentSymptomMapper appointmentSymptomMapper;

    @Override
    public AppointmentSymptomDto createAppointmentSymptom(AppointmentSymptomDto appointmentSymptomDto) {
        if(appointmentSymptomDto == null) {
            return null;
        }
        AppointmentSymptom appointmentSymptom = appointmentSymptomRepository.save(appointmentSymptomMapper.mapToEntity(appointmentSymptomDto));
        return appointmentSymptomMapper.mapToDto(appointmentSymptom);
    }

    @Override
    public List<AppointmentSymptomDto> findAllByAppointmentId(int id) {
        List<AppointmentSymptom> appointmentSymptomList = appointmentSymptomRepository.findByAppointmentId(id);
        return appointmentSymptomList.stream().map(as -> appointmentSymptomMapper.mapToDto(as)).toList();
    }

    @Override
    public List<AppointmentSymptomDto> findAllBySymptomId(int id) {
        List<AppointmentSymptom> appointmentSymptomList = appointmentSymptomRepository.findBySymptomId(id);
        return appointmentSymptomList.stream().map(as -> appointmentSymptomMapper.mapToDto(as)).toList();
    }


    @Override
    public List<AppointmentSymptomDto> findAll() {
        List<AppointmentSymptom> appointmentSymptomList = appointmentSymptomRepository.findAll();
        return appointmentSymptomList.stream().map(as -> appointmentSymptomMapper.mapToDto(as)).toList();
    }
}
