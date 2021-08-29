package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class problemeTechnicien {

    @EmbeddedId
    problemeTechnicienId id;

    @ManyToOne
    @MapsId("idProbleme")
    @JoinColumn(name = "idProbleme")
    probleme probleme;

    @ManyToOne
    @MapsId("idTechnicien")
    @JoinColumn(name = "idTechnicien")
    technicien technicien;

    public problemeTechnicien(problemeTechnicienId id, com.example.stage.Entities.probleme probleme, com.example.stage.Entities.technicien technicien) {
        this.id = id;
        this.probleme = probleme;
        this.technicien = technicien;
    }

    public problemeTechnicien() {
    }
}
