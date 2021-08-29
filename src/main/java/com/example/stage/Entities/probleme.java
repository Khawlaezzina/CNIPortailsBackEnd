package com.example.stage.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity @Data
@Table(name ="probleme")
public class probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    @Column(name ="dateOuverture")
    @NotBlank(message = "La date d'ouverture est obligatoire")
    private String dateOuverture;

    @Column(name="sujet")
    @NotBlank(message = "Le sujet est obligatoire")
    private String sujet;

    @Column(name="ticketStatut")
    @NotBlank(message = "Le statut est obligatoire")
    private String ticketStatut;

    @Column(name="description")
    @NotBlank(message = "La description est obligatoire")
    private String description;

    @Column(name="impact")
    private String impact;

    @Column(name="urgence")
    private String urgence;

    @Column(name="cause")
    private String cause;

    @Column(name="motCle")
    private String motCle;

    @Column(name="solution")
    private String solution;

    @Column(name="typeDeSolution")
    private String typeDeSolution;

    @Column(name="priorite")
    private Long priorite;

    @OneToMany(mappedBy = "idProbleme")
    @JsonIgnore
    private Set<incident> incidents;

    @ManyToOne
    @JoinColumn(name="idApprobateur")
    private approbateur idApprobateur;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private utilisateurSimple idUtilisateur;

    @OneToMany(mappedBy = "probleme")
    @JsonIgnore
    Set<CIProbleme> CIProbleme;

    @OneToMany(mappedBy = "probleme")
     @JsonIgnore
    Set<problemeTechnicien> problemeTechnicien;


    public probleme(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, String impact, String urgence, String cause, String motCle, String solution, String typeDeSolution, Long priorite, Set<incident> incidents, approbateur idApprobateur, utilisateurSimple idUtilisateur, Set<com.example.stage.Entities.CIProbleme> CIProbleme, Set<com.example.stage.Entities.problemeTechnicien> problemeTechnicien) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.impact = impact;
        this.urgence = urgence;
        this.cause = cause;
        this.motCle = motCle;
        this.solution = solution;
        this.typeDeSolution = typeDeSolution;
        this.priorite = priorite;
        this.incidents = incidents;
        this.idApprobateur = idApprobateur;
        this.idUtilisateur = idUtilisateur;
        this.CIProbleme = CIProbleme;
        this.problemeTechnicien = problemeTechnicien;
    }

    public probleme(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, String impact, String urgence, String cause, String motCle, String solution, String typeDeSolution, Long priorite,approbateur idApprobateur, utilisateurSimple idUtilisateur) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.impact = impact;
        this.urgence = urgence;
        this.cause = cause;
        this.motCle = motCle;
        this.solution = solution;
        this.typeDeSolution = typeDeSolution;
        this.priorite = priorite;
        this.idApprobateur = idApprobateur;
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "probleme{" +
                "id=" + id +
                ", dateOuverture=" + dateOuverture +
                ", sujet='" + sujet + '\'' +
                ", ticketStatut='" + ticketStatut + '\'' +
                ", description='" + description + '\'' +
                ", cause='" + cause + '\'' +
                ", motCle='" + motCle + '\'' +
                ", solution='" + solution + '\'' +
                ", typeDeSolution='" + typeDeSolution + '\'' +
                ", incidents=" + incidents +
                ", idApprobateur=" + idApprobateur +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }

    public probleme() {
    }
}