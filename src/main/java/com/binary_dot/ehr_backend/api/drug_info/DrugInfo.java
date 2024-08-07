package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.api.drug.Drug;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturer;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_info")
public class DrugInfo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private int qty;

    private String expDate;

    private String dosage;

    @ManyToOne()
    @JoinColumn(name = "drug_manufacturer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DrugManufacturer drugManufacturer;

    @ManyToOne()
    @JoinColumn(name = "drug_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Drug drug;

    @OneToMany(mappedBy = "drugInfo")
    private List<TreatmentDrugInternal> treatmentDrugInternalList;
}
