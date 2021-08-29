package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class changementTechnicien {

    @EmbeddedId
    changementTechnicienId id;

    @ManyToOne
    @MapsId("changementId")
    @JoinColumn(name = "idChangement")
    changement changement;

    @ManyToOne
    @MapsId("technicienId")
    @JoinColumn(name = "idTechnicien")
    technicien technicien;

    public changementTechnicien() {
    }

    public changementTechnicien(changementTechnicienId id, com.example.stage.Entities.changement changement, com.example.stage.Entities.technicien technicien) {
        this.id = id;
        this.changement = changement;
        this.technicien = technicien;
    }

}
