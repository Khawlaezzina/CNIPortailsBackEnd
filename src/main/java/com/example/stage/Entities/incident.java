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
@Table(name ="incident")
public class incident {
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

    @Column(name="impact")

    private String impact;

    @Column(name="urgence")

    private String urgence;


    @ManyToOne
    @JoinColumn(name="idProbleme")
    private probleme idProbleme;

    @ManyToOne
    @JoinColumn(name="idApprobateur")
    private approbateur idApprobateur;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private utilisateurSimple idUtilisateur;

    @OneToMany(mappedBy = "incident",cascade = {CascadeType.ALL})
    @JsonIgnore
    Set<incidentTechnicien> incidentTechnicien;
    public incident() {
    }

    public incident(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, String cause, String motCle, String solution, String typeDeSolution, Long priorite, String impact, String urgence, probleme idProbleme, approbateur idApprobateur, utilisateurSimple idUtilisateur) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.cause = cause;
        this.motCle = motCle;
        this.solution = solution;
        this.typeDeSolution = typeDeSolution;
        this.priorite = priorite;
        this.impact = impact;
        this.urgence = urgence;

        this.idProbleme = idProbleme;
        this.idApprobateur = idApprobateur;
        this.idUtilisateur = idUtilisateur;
    }

    public incident(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, String cause, String motCle, String solution, String typeDeSolution, Long priorite, String impact, String urgence) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.cause = cause;
        this.motCle = motCle;
        this.solution = solution;
        this.typeDeSolution = typeDeSolution;
        this.priorite = priorite;
        this.impact = impact;
        this.urgence = urgence;

    }

    public incident(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, String cause, String motCle, String solution, String typeDeSolution, Long priorite, String impact, String urgence, probleme idProbleme) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.cause = cause;
        this.motCle = motCle;
        this.solution = solution;
        this.typeDeSolution = typeDeSolution;
        this.priorite = priorite;
        this.impact = impact;
        this.urgence = urgence;

        this.idProbleme = idProbleme;
    }

    @Override
    public String toString() {
        return "incident{" +
                "id=" + id +
                ", dateOuverture=" + dateOuverture +
                ", sujet='" + sujet + '\'' +
                ", ticketStatut='" + ticketStatut + '\'' +
                ", description='" + description + '\'' +
                ", cause='" + cause + '\'' +
                ", motCle='" + motCle + '\'' +
                ", solution='" + solution + '\'' +
                ", typeDeSolution='" + typeDeSolution + '\'' +
                ", priorite=" + priorite +
                ", impact='" + impact + '\'' +
                ", urgence='" + urgence + '\'' +

                ", idProbleme=" + idProbleme +
                ", idApprobateur=" + idApprobateur +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }
}
