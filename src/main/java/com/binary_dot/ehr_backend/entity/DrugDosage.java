package com.binary_dot.ehr_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_dosage")
public class DrugDosage {
    @EmbeddedId
    private DrugDosageId id;

    @ManyToOne
    @MapsId("drugId")
    @JoinColumn(name="drug_id")
    private Drug drug;

    @ManyToOne
    @MapsId("dosageId")
    @JoinColumn(name="dosage_id")
    private Dosage dosage;

    @Column(name = "exp_date")
    private Date expDate;

    private int qty;

}
