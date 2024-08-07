package com.binary_dot.ehr_backend.api.drug_info;

import com.binary_dot.ehr_backend.api.drug.DrugDto;
import com.binary_dot.ehr_backend.api.drug_manufacturer.DrugManufacturerDto;
import com.binary_dot.ehr_backend.api.treatment_drug_internal.TreatmentDrugInternalDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugInfoDto {
    private int id;

    private int qty;

    private String expDate;

    private String dosage;

    @JsonIgnoreProperties("drugInfoList")
    private DrugManufacturerDto drugManufacturer;

    @JsonIgnoreProperties("drugInfoList")
    private DrugDto drug;

    @JsonIgnore
    private List<TreatmentDrugInternalDto> treatmentDrugInternalList;
}
