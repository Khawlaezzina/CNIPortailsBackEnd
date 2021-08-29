package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CIChangement {

    @EmbeddedId
    CIChangementId id;


    @ManyToOne
    @MapsId("idChangement")
    @JoinColumn(name = "idChangement")
    changement changement;

    @ManyToOne
    @MapsId("idCI")
    @JoinColumn(name = "idCI")
    CI CI;

    public CIChangement() {
    }

    public CIChangement(CIChangementId id, com.example.stage.Entities.changement changement, com.example.stage.Entities.CI CI) {
        this.id = id;
        this.changement = changement;
        this.CI = CI;
    }


}
