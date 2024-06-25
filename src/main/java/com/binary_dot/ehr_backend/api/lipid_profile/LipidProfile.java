package com.binary_dot.ehr_backend.api.lipid_profile;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lipid_profile")
public class LipidProfile {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "lipidProfile")
    private Appointment appointment;

    @Column(name = "total_cholesterol")
    private String totalCholesterol;

    @Column(name = "s_tg")
    private String stg;

    private String hdl;

    private String ldl;

    @Column(name = "cho_hdl")
    private String choHDL;

}
