package com.binary_dot.ehr_backend.api.patient;

import com.binary_dot.ehr_backend.api.appointment.AppointmentImpl;
import com.binary_dot.ehr_backend.api.drug_allergy.DrugAllergy;
import com.binary_dot.ehr_backend.api.drug_allergy.DrugAllergyMapper;
import com.binary_dot.ehr_backend.api.drug_allergy.DrugAllergyService;
import com.binary_dot.ehr_backend.api.food_allergy.FoodAllergy;
import com.binary_dot.ehr_backend.api.food_allergy.FoodAllergyMapper;
import com.binary_dot.ehr_backend.api.food_allergy.FoodAllergyService;
import com.binary_dot.ehr_backend.api.medical_history.MedicalHistory;
import com.binary_dot.ehr_backend.api.medical_history.MedicalHistoryMapper;
import com.binary_dot.ehr_backend.api.medical_history.MedicalHistoryService;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelationDto;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelationMapper;
import com.binary_dot.ehr_backend.api.patient_relation.PatientRelationService;
import com.binary_dot.ehr_backend.api.social_history.SocialHistory;
import com.binary_dot.ehr_backend.api.social_history.SocialHistoryMapper;
import com.binary_dot.ehr_backend.api.social_history.SocialHistoryService;
import com.binary_dot.ehr_backend.api.surgical_history.SurgicalHistory;
import com.binary_dot.ehr_backend.api.surgical_history.SurgicalHistoryMapper;
import com.binary_dot.ehr_backend.api.surgical_history.SurgicalHistoryService;
import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientImpl implements PatientService {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentImpl.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    // External Services
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private SocialHistoryService socialHistoryService;

    @Autowired
    private SurgicalHistoryService surgicalHistoryService;

    @Autowired
    private FoodAllergyService foodAllergyService;

    @Autowired
    private DrugAllergyService drugAllergyService;

    @Autowired
    private PatientRelationService patientRelationService;

    // External Mappers
    @Autowired
    private MedicalHistoryMapper medicalHistoryMapper;

    @Autowired
    private SocialHistoryMapper socialHistoryMapper;

    @Autowired
    private SurgicalHistoryMapper surgicalHistoryMapper;

    @Autowired
    private FoodAllergyMapper foodAllergyMapper;

    @Autowired
    private DrugAllergyMapper drugAllergyMapper;

    @Autowired
    private PatientRelationMapper patientRelationMapper;

    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        logger.info("Start adding Patient ----------------");
        long startTime, endTime, totalStartTime, totalEndTime;

        if (patientDto == null) {
            return null;
        }
        totalStartTime = System.currentTimeMillis();
        Optional<Patient> existingPatient = patientRepository.findById(patientDto.getId());
        if (existingPatient.isPresent()) {
            return patientMapper.mapToDto(existingPatient.get());
        }

        startTime = System.currentTimeMillis();
        Patient patientEntity = patientMapper.mapToEntity(patientDto);
        endTime = System.currentTimeMillis();
        logger.info("Time taken for Checking for existing patient: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        MedicalHistory medicalHistory = medicalHistoryMapper.mapToEntity(medicalHistoryService.addMedicalHistory(patientDto.getMedicalHistory()));
        endTime = System.currentTimeMillis();
        logger.info("Time taken for MedicalHistoryService: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        SocialHistory socialHistory = socialHistoryMapper.mapToEntity(socialHistoryService.addSocialHistory(patientDto.getSocialHistory()));
        endTime = System.currentTimeMillis();
        logger.info("Time taken for SocialHistoryService: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        SurgicalHistory surgicalHistory = surgicalHistoryMapper.mapToEntity(surgicalHistoryService.addSurgicalHistory(patientDto.getSurgicalHistory()));
        endTime = System.currentTimeMillis();
        logger.info("Time taken for SurgicalHistoryService: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        List<FoodAllergy> foodAllergies = foodAllergyService.addFoodAllergies(patientDto.getFoodAllergies()).stream().map(allergy -> foodAllergyMapper.mapToEntity(allergy)).toList();
        endTime = System.currentTimeMillis();
        logger.info("Time taken for FoodAllergyService: {} ms", endTime - startTime);

        startTime = System.currentTimeMillis();
        List<DrugAllergy> drugAllergies = drugAllergyService.addDrugAllergies(patientDto.getDrugAllergies()).stream().map(allergy -> drugAllergyMapper.mapToEntity(allergy)).toList();
        endTime = System.currentTimeMillis();
        logger.info("Time taken for DrugAllergyService: {} ms", endTime - startTime);

        patientEntity.setMedicalHistory(medicalHistory);
        patientEntity.setSocialHistory(socialHistory);
        patientEntity.setSurgicalHistory(surgicalHistory);
        patientEntity.setFoodAllergies(foodAllergies);
        patientEntity.setDrugAllergies(drugAllergies);
        patientEntity.setRelations(null);

        startTime = System.currentTimeMillis();
        Patient patient = patientRepository.save(patientEntity);
        endTime = System.currentTimeMillis();
        logger.info("Time taken for PatientRepository.save: {} ms", endTime - startTime);

        if (patientDto.getRelations() != null) {
            for (PatientRelationDto relation : patientDto.getRelations()) {
                startTime = System.currentTimeMillis();
                PatientDto relatedPatient = addPatient(relation.getRelatedPatient());
                endTime = System.currentTimeMillis();
                logger.info("Time taken for addPatient (relation): {} ms", endTime - startTime);

                relation.setPatient(patientMapper.mapToDto(patient));
                relation.setRelatedPatient(relatedPatient);

                startTime = System.currentTimeMillis();
                patientRelationService.createPatientRelation(relation);
                endTime = System.currentTimeMillis();
                logger.info("Time taken for PatientRelationService.createPatientRelation: {} ms", endTime - startTime);
            }
        }

        totalEndTime = System.currentTimeMillis();
        PatientDto patientDto1 = patientMapper.mapToDto(patient);
        logger.info("Time taken for Whole Patient: {} ms", totalEndTime - totalStartTime);
        return patientDto1;
    }

    @Override
    public PatientDto findById(int id) throws NotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Patient Not Found By Id: " + id)
        );
        return patientMapper.mapToDto(patient);
    }

    @Override
    public Page<PatientDto> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Patient> patients = patientRepository.findAll(pageable);
        return patients.map(patient -> patientMapper.mapToDto(patient));
    }
}
