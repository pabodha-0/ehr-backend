package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dosage")
public class Dosage {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

//    @OneToMany(mappedBy = "dosage", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<DrugDosage> drugDosage;

    private String dose;
}
