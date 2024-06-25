package com.binary_dot.ehr_backend.api.lipid_profile;

import com.binary_dot.ehr_backend.api.appointment.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LipidProfileDto {
    private int id;

    private AppointmentDto appointment;

    private String totalCholesterol;

    private String stg;

    private String hdl;

    private String ldl;

    private String choHDL;

}
