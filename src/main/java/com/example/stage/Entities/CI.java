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
@Table(name ="CI")
public class CI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    @Column(name ="nom")
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Column(name ="organisation")
    private String organisation;

    @Column(name ="statut")
    private String statut;

    @Column(name ="criticite")
    private String criticite;

    @Column(name ="description")
    private String description;

    @Column(name ="emplacement")
    private String emplacement;

    @OneToMany(mappedBy = "CI")
    @JsonIgnore
    Set<CIChangement> CIChangement;

    @OneToMany(mappedBy = "CI")
    @JsonIgnore
    Set<CIProbleme> CIProbleme;
    public CI() {
    }

    public CI(long id, @NotBlank(message = "Le nom est obligatoire") String nom, @NotBlank(message = "L'organisation est obligatoire") String organisation, @NotBlank(message = "Le statut est obligatoire") String statut, @NotBlank(message = "La criticité est obligatoire") String criticite, @NotBlank(message = "La description est obligatoire") String description, @NotBlank(message = "L'emplacement est obligatoire") String emplacement) {
        this.id = id;
        this.nom = nom;
        this.organisation = organisation;
        this.statut = statut;
        this.criticite = criticite;
        this.description = description;
        this.emplacement = emplacement;
    }

    @Override
    public String toString() {
        return "CI{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", organisation='" + organisation + '\'' +
                ", statut='" + statut + '\'' +
                ", criticite='" + criticite + '\'' +
                ", description='" + description + '\'' +
                ", emplacement='" + emplacement + '\'' +
                '}';
    }
}
