package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CIProbleme {

    @EmbeddedId
    CIProblemeId id;


    @ManyToOne
    @MapsId("idProbleme")
    @JoinColumn(name = "idProbleme")
    probleme probleme;

    @ManyToOne
    @MapsId("idCI")
    @JoinColumn(name = "idCI")
    CI CI;

    public CIProbleme() {
    }

    public CIProbleme(CIProblemeId id, com.example.stage.Entities.probleme probleme, com.example.stage.Entities.CI CI) {
        this.id = id;
        this.probleme = probleme;
        this.CI = CI;
    }
}
