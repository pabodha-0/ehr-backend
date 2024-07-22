package com.binary_dot.ehr_backend.api.drug_manufacturer;

import com.binary_dot.ehr_backend.api.drug_info.DrugInfo;
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
@Table(name = "drug_manufacturer")
public class DrugManufacturer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "drugManufacturer", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<DrugInfo> drugInfoList;
}
