package com.binary_dot.ehr_backend.api.appointment;

import com.binary_dot.ehr_backend.api.appointment_symptom.*;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportDto;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportMapper;
import com.binary_dot.ehr_backend.api.blood_report.BloodReportService;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportDto;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportMapper;
import com.binary_dot.ehr_backend.api.blood_sugar_report.BloodSugarReportService;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisDto;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisMapper;
import com.binary_dot.ehr_backend.api.diagnosis.DiagnosisService;
import com.binary_dot.ehr_backend.api.drug_info.DrugInfoDto;
import com.binary_dot.ehr_backend.api.drug_info.DrugInfoService;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportDto;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportMapper;
import com.binary_dot.ehr_backend.api.examination_report.ExaminationReportService;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportDto;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileDto;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportDto;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportDto;
import com.binary_dot.ehr_backend.api.patient.PatientDto;
import com.binary_dot.ehr_backend.api.symptom.SymptomDto;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportDto;
import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternalDto;
import com.binary_dot.ehr_backend.api.treatment_drug_external.TreatmentDrugExternalService;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalService;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportDto;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportMapper;
import com.binary_dot.ehr_backend.api.kidney_report.KidneyReportService;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileMapper;
import com.binary_dot.ehr_backend.api.lipid_profile.LipidProfileService;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportMapper;
import com.binary_dot.ehr_backend.api.liver_report.LiverReportService;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportMapper;
import com.binary_dot.ehr_backend.api.other_test_report.OtherTestReportService;
import com.binary_dot.ehr_backend.api.patient.PatientMapper;
import com.binary_dot.ehr_backend.api.patient.PatientService;
import com.binary_dot.ehr_backend.api.symptom.SymptomMapper;
import com.binary_dot.ehr_backend.api.symptom.SymptomService;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportMapper;
import com.binary_dot.ehr_backend.api.thyroid_report.ThyroidReportService;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportMapper;
import com.binary_dot.ehr_backend.api.urine_report.UrineReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentImpl implements AppointmentService {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentImpl.class);


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    // External Services
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

    @Autowired
    private TreatmentDrugExternalService treatmentDrugExternalService;

    @Autowired
    private TreatmentDrugInternalService treatmentDrugInternalService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Override
    public AppointmentDto addEntry(AppointmentDto appointmentDto) {
        long startTime = System.currentTimeMillis();
        logger.info("Start adding appointment");

        long stepTime = System.currentTimeMillis();
        PatientDto patientDto = patientService.addPatient(appointmentDto.getPatient());
        logger.info("Time taken for PatientService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        ExaminationReportDto examinationReportDto = examinationReportService.createExaminationReport(appointmentDto.getExaminationReport());
        logger.info("Time taken for ExaminationReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        BloodReportDto bloodReportDto = bloodReportService.addBloodReport(appointmentDto.getBloodReport());
        logger.info("Time taken for BloodReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        BloodSugarReportDto bloodSugarReportDto = bloodSugarReportService.addBloodSugarReport(appointmentDto.getBloodSugarReport());
        logger.info("Time taken for BloodSugarReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        KidneyReportDto kidneyReportDto = kidneyReportService.addKidneyReport(appointmentDto.getKidneyReport());
        logger.info("Time taken for KidneyReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        LipidProfileDto lipidProfileDto = lipidProfileService.addLipidProfile(appointmentDto.getLipidProfile());
        logger.info("Time taken for LipidProfileService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        LiverReportDto liverReportDto = liverReportService.addLiverReport(appointmentDto.getLiverReport());
        logger.info("Time taken for LiverReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        OtherTestReportDto otherTestReportDto = otherTestReportService.addOtherTestReport(appointmentDto.getOtherTestReport());
        logger.info("Time taken for OtherTestReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        ThyroidReportDto thyroidReportDto = thyroidReportService.addThyroidReport(appointmentDto.getThyroidReport());
        logger.info("Time taken for ThyroidReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        UrineReportDto urineReportDto = urineReportService.addUrineReport(appointmentDto.getUrineReport());
        logger.info("Time taken for UrineReportService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        List<TreatmentDrugExternalDto> treatmentDrugExternalDtoList = treatmentDrugExternalService.createExternalTreatmentDrugs(appointmentDto.getTreatmentDrugExternalList());
        logger.info("Time taken for TreatmentDrugExternalService: {} ms", System.currentTimeMillis() - stepTime);

        stepTime = System.currentTimeMillis();
        List<DiagnosisDto> diagnosisDtoList = diagnosisService.createDiagnoses(appointmentDto.getDiagnoses());
        logger.info("Time taken for DiagnosisService: {} ms", System.currentTimeMillis() - stepTime);

        appointmentDto.setPatient(patientDto);
        appointmentDto.setExaminationReport(examinationReportDto);
        appointmentDto.setBloodReport(bloodReportDto);
        appointmentDto.setBloodSugarReport(bloodSugarReportDto);
        appointmentDto.setKidneyReport(kidneyReportDto);
        appointmentDto.setLipidProfile(lipidProfileDto);
        appointmentDto.setLiverReport(liverReportDto);
        appointmentDto.setOtherTestReport(otherTestReportDto);
        appointmentDto.setThyroidReport(thyroidReportDto);
        appointmentDto.setUrineReport(urineReportDto);
        appointmentDto.setTreatmentDrugExternalList(treatmentDrugExternalDtoList);
        appointmentDto.setDiagnoses(diagnosisDtoList);

        List<AppointmentSymptomDto> appointmentSymptomList = appointmentDto.getAppointmentSymptoms();
        List<TreatmentDrugInternalDto> treatmentDrugInternalDtoList = appointmentDto.getTreatmentDrugInternalList();

        appointmentDto.setAppointmentSymptoms(null);
        appointmentDto.setTreatmentDrugInternalList(null);

        stepTime = System.currentTimeMillis();
        AppointmentDto savedAppointment = appointmentMapper.mapToDto(appointmentRepository.save(appointmentMapper.mapToEntity(appointmentDto)));
        logger.info("Time taken for saving Appointment: {} ms", System.currentTimeMillis() - stepTime);

        if(appointmentSymptomList != null){
            for (AppointmentSymptomDto appointmentSymptomDto :  appointmentSymptomList) {
                stepTime = System.currentTimeMillis();
                SymptomDto symptomDto = symptomService.addSymptom(appointmentSymptomDto.getSymptom());
                logger.info("Time taken for SymptomService: {} ms", System.currentTimeMillis() - stepTime);

                appointmentSymptomDto.setAppointment(savedAppointment);
                appointmentSymptomDto.setSymptom(symptomDto);

                stepTime = System.currentTimeMillis();
                appointmentSymptomService.createAppointmentSymptom(appointmentSymptomDto);
                logger.info("Time taken for AppointmentSymptomService: {} ms", System.currentTimeMillis() - stepTime);
            }
        }

        if (treatmentDrugInternalDtoList != null) {
            for (TreatmentDrugInternalDto treatmentDrugInternalDto : treatmentDrugInternalDtoList) {
                treatmentDrugInternalDto.setAppointment(savedAppointment);
                stepTime = System.currentTimeMillis();
                treatmentDrugInternalService.createTreatmentDrugInternal(treatmentDrugInternalDto);
                logger.info("Time taken for TreatmentDrugInternalService: {} ms", System.currentTimeMillis() - stepTime);
            }
        }

        long endTime = System.currentTimeMillis();
        logger.info("Total time taken for addEntry: {} ms", endTime - startTime);

        return savedAppointment;
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
