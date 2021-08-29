package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class incidentTechnicien {

    @EmbeddedId
    incidentTechnicienId id;

    @ManyToOne
    @MapsId("idIncident")
    @JoinColumn(name = "idIncident")
    incident incident;

    @ManyToOne
    @MapsId("idTechnicien")
    @JoinColumn(name = "idTechnicien")
    technicien technicien;

    public incidentTechnicien(incidentTechnicienId id, com.example.stage.Entities.incident incident, com.example.stage.Entities.technicien technicien) {
        this.id = id;
        this.incident = incident;
        this.technicien = technicien;
    }

    public incidentTechnicien() {
    }
}
