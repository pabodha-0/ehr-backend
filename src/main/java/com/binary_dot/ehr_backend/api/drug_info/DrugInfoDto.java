package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.api.drug.DrugDto;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturerDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugInfoDto {
    private int id;

    private int qty;

    private Date expDate;

    private String Dosage;

    private DrugManufacturerDto drugManufacturer;

    private DrugDto drug;

    private List<TreatmentDrugInternalDto> treatmentDrugInternalList;
}
