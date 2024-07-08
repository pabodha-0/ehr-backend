package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.api.appointment_symptom.*;
import com.binary_dot.ehr_backend.api.blood_report.BloodReport;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportMapper;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportService;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReport;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportMapper;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportService;
import com.binary_dot.ehr_backend.api.diagnosis.Diagnosis;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisMapper;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisService;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReport;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportMapper;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportService;
import com.binary_dot.ehr_backend.api.symptom.SymptomDto;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReport;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportMapper;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportService;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfile;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileMapper;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileService;
import com.binary_dot.ehr_backend.api.liver_report.LiverReport;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportMapper;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportService;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReport;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportMapper;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportService;
import com.binary_dot.ehr_backend.api.patient.Patient;
import com.binary_dot.ehr_backend.api.patient.PatientMapper;
import com.binary_dot.ehr_backend.api.patient.PatientService;
import com.binary_dot.ehr_backend.api.symptom.Symptom;
import com.binary_dot.ehr_backend.api.symptom.SymptomMapper;
import com.binary_dot.ehr_backend.api.symptom.SymptomService;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReport;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportMapper;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportService;
import com.binary_dot.ehr_backend.api.urine_report.UrineReport;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportMapper;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

//  External Services
    @Autowired
    private PatientService patientService;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private AppointmentSymptomService appointmentSymptomService;

    @Autowired
    private ExaminationReportService examinationReportService;

    @Autowired
    private BloodReportService bloodReportService;

    @Autowired
    private BloodSugarReportService bloodSugarReportService;

    @Autowired
    private KidneyReportService kidneyReportService;

    @Autowired
    private LipidProfileService lipidProfileService;

    @Autowired
    private LiverReportService liverReportService;

    @Autowired
    private OtherTestReportService otherTestReportService;

    @Autowired
    private ThyroidReportService thyroidReportService;

    @Autowired
    private UrineReportService urineReportService;

    @Autowired
    private DiagnosisService diagnosisService;

//  External Mappers
    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private SymptomMapper symptomMapper;

    @Autowired
    private AppointmentSymptomMapper appointmentSymptomMapper;

    @Autowired
    private ExaminationReportMapper examinationReportMapper;

    @Autowired
    private BloodReportMapper bloodReportMapper;

    @Autowired
    private BloodSugarReportMapper bloodSugarReportMapper;

    @Autowired
    private KidneyReportMapper kidneyReportMapper;

    @Autowired
    private LipidProfileMapper lipidProfileMapper;

    @Autowired
    private LiverReportMapper liverReportMapper;

    @Autowired
    private OtherTestReportMapper otherTestReportMapper;

    @Autowired
    private ThyroidReportMapper thyroidReportMapper;

    @Autowired
    private UrineReportMapper urineReportMapper;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Override
    public AppointmentDto addEntry(AppointmentDto appointmentDto) {
        Patient patient = patientMapper.mapToEntity(patientService.addPatient(appointmentDto.getPatient()));
        ExaminationReport examinationReport = examinationReportMapper.mapToEntity(examinationReportService.createExaminationReport(appointmentDto.getExaminationReport()));
        BloodReport bloodReport = bloodReportMapper.mapToEntity(bloodReportService.addBloodReport(appointmentDto.getBloodReport()));
        BloodSugarReport bloodSugarReport = bloodSugarReportMapper.mapToEntity(bloodSugarReportService.addBloodSugarReport(appointmentDto.getBloodSugarReport()));
        KidneyReport kidneyReport = kidneyReportMapper.mapToEntity(kidneyReportService.addKidneyReport(appointmentDto.getKidneyReport()));
        LipidProfile lipidProfile = lipidProfileMapper.mapToEntity(lipidProfileService.addLipidProfile(appointmentDto.getLipidProfile()));
        LiverReport liverReport = liverReportMapper.mapToEntity(liverReportService.addLiverReport(appointmentDto.getLiverReport()));
        OtherTestReport otherTestReport = otherTestReportMapper.mapToEntity(otherTestReportService.addOtherTestReport(appointmentDto.getOtherTestReport()));
        ThyroidReport thyroidReport = thyroidReportMapper.mapToEntity(thyroidReportService.addThyroidReport(appointmentDto.getThyroidReport()));
        UrineReport urineReport = urineReportMapper.mapToEntity(urineReportService.addUrineReport(appointmentDto.getUrineReport()));
        List<Diagnosis> diagnosisList = diagnosisService.createDiagnoses(appointmentDto.getDiagnoses()).stream().map(diagnosis -> diagnosisMapper.mapToEntity(diagnosis)).toList();

        Appointment appointmentEntity = appointmentMapper.mapToEntity(appointmentDto);
        appointmentEntity.setPatient(patient);
        appointmentEntity.setExaminationReport(examinationReport);
        appointmentEntity.setBloodReport(bloodReport);
        appointmentEntity.setBloodSugarReport(bloodSugarReport);
        appointmentEntity.setKidneyReport(kidneyReport);
        appointmentEntity.setLipidProfile(lipidProfile);
        appointmentEntity.setLiverReport(liverReport);
        appointmentEntity.setOtherTestReport(otherTestReport);
        appointmentEntity.setThyroidReport(thyroidReport);
        appointmentEntity.setUrineReport(urineReport);
        appointmentEntity.setAppointmentSymptoms(null);
        appointmentEntity.setDiagnoses(diagnosisList);

        Appointment appointment = appointmentRepository.save(appointmentEntity);

        if(appointmentDto.getAppointmentSymptoms() != null){
            for (AppointmentSymptomDto appointmentSymptomDto :  appointmentDto.getAppointmentSymptoms()) {
                SymptomDto symptomDto = symptomService.addSymptom(appointmentSymptomDto.getSymptom());
                appointmentSymptomDto.setAppointment(appointmentMapper.mapToDto(appointment));
                appointmentSymptomDto.setSymptom(symptomDto);

                appointmentSymptomService.createAppointmentSymptom(appointmentSymptomDto);
            }
        }

        return appointmentMapper.mapToDto(appointment);
    }

    @Override
    public List<AppointmentDto> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(appointment -> appointmentMapper.mapToDto(appointment)).toList();
    }

    @Override
    public AppointmentDto findById(int id) throws NotFoundException {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return appointmentMapper.mapToDto(appointment.get());
        }
        throw new NotFoundException("Appointment Not Found By Id: " + id);
    }
}
