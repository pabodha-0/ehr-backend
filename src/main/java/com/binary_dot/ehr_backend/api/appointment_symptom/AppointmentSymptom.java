package com.binary_dot.ehr_backend.api.appointment_symptom;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.symptom.Symptom;
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
@Table(name = "appointment_symptom")
public class AppointmentSymptom {
    @EmbeddedId
    AppointmentSymptomId id;

    @ManyToOne
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @MapsId("symptomId")
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    private String duration;


}
