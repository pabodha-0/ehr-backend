package com.binary_dot.ehr_backend.api.drug_allergy;

import com.binary_dot.ehr_backend.api.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_allergy")
public class DrugAllergy {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "drugAllergies")
    List<Patient> patients;

    private String name;
}
