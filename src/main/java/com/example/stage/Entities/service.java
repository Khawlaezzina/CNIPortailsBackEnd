package com.example.stage.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name ="service")
public class service {
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

    @Column(name="priorite")

    private Long priorite;

    @Column(name="impact")

    private String impact;

    @Column(name="urgence")

    private String urgence;

    @ManyToOne
    @JoinColumn(name="idApprobateur")
    private approbateur idApprobateur;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private utilisateurSimple idUtilisateur;

    @OneToMany(mappedBy = "service")
    @JsonIgnore
    Set<serviceTechnicien> serviceTechnicien;
    public service() {
    }

    public service(long id, @NotBlank(message = "La date d'ouverture est obligatoire") String dateOuverture, @NotBlank(message = "Le sujet est obligatoire") String sujet, @NotBlank(message = "Le statut est obligatoire") String ticketStatut, @NotBlank(message = "La description est obligatoire") String description, Long priorite, String impact, String urgence, approbateur idApprobateur, utilisateurSimple idUtilisateur) {
        this.id = id;
        this.dateOuverture = dateOuverture;
        this.sujet = sujet;
        this.ticketStatut = ticketStatut;
        this.description = description;
        this.priorite = priorite;
        this.impact = impact;
        this.urgence = urgence;
        this.idApprobateur = idApprobateur;
        this.idUtilisateur = idUtilisateur;


    }

    @Override
    public String toString() {
        return "service{" +
                "id=" + id +
                ", dateOuverture=" + dateOuverture +
                ", sujet='" + sujet + '\'' +
                ", ticketStatut='" + ticketStatut + '\'' +
                ", description='" + description + '\'' +
                ", priorite=" + priorite +
                ", impact=" + impact +
                ", urgence=" + urgence +
                ", idApprobateur=" + idApprobateur +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }
}
