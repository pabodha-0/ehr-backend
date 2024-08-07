package com.binary_dot.ehr_backend.api.drug;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfoDto;
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
public class DrugDto {
    private int id;

    private String name;

//    @JsonIgnoreProperties("drug")
    @JsonIgnore
    private List<DrugInfoDto> drugInfoList;
}
