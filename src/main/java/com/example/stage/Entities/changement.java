package com.example.stage.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity @Data
@Table(name ="changement")
public class changement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    @Column(name ="dateOuverture")
    @NotBlank(message = "La date d'ouverture est obligatoire")
    private String  dateOuverture;

    @Column(name ="dateFin")

    private String dateFin;

    @Column(name ="statut")
    private String statut;

    @Column(name ="description")
    private String description;

    @Column(name ="type")
    @NotBlank(message = "Le type est obligatoire")
    private String type;

    @OneToMany(mappedBy = "idChangement")
    @JsonIgnore
    private Set<tache> taches;

    @OneToMany(mappedBy = "changement")
    @JsonIgnore
    Set<changementTechnicien> changementTechnicien;

    @OneToMany(mappedBy = "changement")
    @JsonIgnore
    Set<CIChangement> CIChangement;

    public changement() {
    }

    public changement(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "La date de fin est obligatoire") String dateFin, String statut, String type) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.dateFin = dateFin;
        this.statut = statut;
        this.type = type;
    }

    @Override
    public String toString() {
        return "changement{" +
                "id=" + id +
                ", dateOuverture=" + dateOuverture +
                ", dateFin=" + dateFin +
                ", statut='" + statut + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
