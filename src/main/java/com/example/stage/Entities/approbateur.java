package com.example.stage.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity @Data
@Table(name ="approbateur",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class approbateur {
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

    @OneToMany(mappedBy = "idApprobateur")
    @JsonIgnore
    private Set<incident> incidents;

    @OneToMany(mappedBy = "idApprobateur")
    @JsonIgnore
    private Set<service> services;

    @OneToMany(mappedBy = "idApprobateur")
    @JsonIgnore
    private Set<probleme> problemes;

    @OneToMany(mappedBy = "idApprobateur")
    @JsonIgnore
    private Set<ticket> tickets;
    public approbateur() {
    }

    public approbateur(long id, @NotBlank(message = "Le nom est obligatoire") String nom, @NotBlank(message = "Le prenom est obligatoire") String prenom, @NotBlank(message = "L'email est obligatoire") String email, String adresse, @NotBlank(message = "Le mot de passe est obligatoire") String password, @NotBlank(message = "Le numéro de telephone est obligatoire") String numeroTelephone, @NotBlank(message = "Le departement est obligatoire") String departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.numeroTelephone = numeroTelephone;
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "approbateur{" +
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
