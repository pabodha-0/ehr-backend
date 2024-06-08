package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DrugDosageId implements Serializable {
    @Column(name = "drug_id")
    private int drugId;

    @Column(name = "dosage_id")
    private int dosageId;
}
