package com.binary_dot.ehr_backend.api.urine_report;

import com.binary_dot.ehr_backend.api.appointment.Appointment;
import com.binary_dot.ehr_backend.api.urine_culture_type.UrineCultureType;
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
@Table(name = "urine_report")
public class UrineReport {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "urineReport")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name="urine_culture_id")
    private UrineCultureType urineCultureType;

    private String albumin;

    private String sugar;

    @Column(name = "pus_cells")
    private int pusCells;

    @Column(name = "red_cells")
    private int redCells;

}
