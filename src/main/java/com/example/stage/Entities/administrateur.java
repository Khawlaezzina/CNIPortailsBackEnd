package com.example.stage.Entities;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity @Data
@Table(name ="administrateur",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class administrateur {
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

    @Column(name ="password")
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;

    @Column(name ="numeroTelephone")
    @NotBlank(message = "Le numéro de telephone est obligatoire")
    private String numeroTelephone;

    @Column(name ="departement")
    @NotBlank(message = "Le departement est obligatoire")
    private String departement;

    public administrateur() {
    }

    public administrateur(long id, @NotBlank(message = "Le nom est obligatoire") String nom, @NotBlank(message = "Le prenom est obligatoire") String prenom, @NotBlank(message = "L'email est obligatoire") String email, String adresse, @NotBlank(message = "Le mot de passe est obligatoire") String password, @NotBlank(message = "Le numéro de telephone est obligatoire") String numeroTelephone, @NotBlank(message = "Le departement est obligatoire") String departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.password = password;

        this.departement = departement;
    }

    @Override
    public String toString() {
        return "administrateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", password='" + password + '\'' +
                ", numeroTelephone=" + numeroTelephone +
                ", departement='" + departement + '\'' +
                '}';
    }
}
