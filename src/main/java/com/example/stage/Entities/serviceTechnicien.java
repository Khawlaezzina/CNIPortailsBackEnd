package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class serviceTechnicien {
    @EmbeddedId
    serviceTechnicienId id;

    @ManyToOne
    @MapsId("idService")
    @JoinColumn(name = "idService")
    service service;

    @ManyToOne
    @MapsId("idTechnicien")
    @JoinColumn(name = "idTechnicien")
    technicien technicien;

    public serviceTechnicien() {
    }

    public serviceTechnicien(serviceTechnicienId id, com.example.stage.Entities.service service, com.example.stage.Entities.technicien technicien) {
        this.id = id;
        this.service = service;
        this.technicien = technicien;
    }
}
