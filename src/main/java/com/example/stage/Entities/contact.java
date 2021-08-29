package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name ="contact")
public class contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    @Column(name ="nom")
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Column(name ="prenom")
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;

    @Column(name ="email",unique = true)
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    @Column(name ="adresse")
    private String adresse;

    @Column(name ="numeroTelephone")
    @NotBlank(message = "Le numéro de telephone est obligatoire")
    private String numeroTelephone;

    @Column(name ="fonction")
    @NotBlank(message = "La fonction est obligatoire")
    private String fonction;
    @Column(name ="statut")
    @NotBlank(message = "Le statut est obligatoire")
    private String statut;
    @Column(name ="organisation")

    private String organisation;

    public contact(long id, @NotBlank(message = "Le nom est obligatoire") String nom, @NotBlank(message = "Le prenom est obligatoire") String prenom, @NotBlank(message = "L'email est obligatoire") String email, String adresse, @NotBlank(message = "Le numéro de telephone est obligatoire") String numeroTelephone, @NotBlank(message = "La fonction est obligatoire") String fonction, @NotBlank(message = "Le statut est obligatoire") String statut, String organisation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.fonction = fonction;
        this.statut = statut;
        this.organisation = organisation;
    }

    public contact() {
    }

    @Override
    public String toString() {
        return "contact{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", fonction='" + fonction + '\'' +
                ", statut='" + statut + '\'' +
                ", organisation='" + organisation + '\'' +
                '}';
    }
}
