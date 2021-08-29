package com.example.stage.Entities;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class utilisateur {

    private long id;


    private String nom;

    private String prenom;

    private String email;

    private String adresse;

    private long numeroTelephone;

    private String departement;

    public utilisateur() {
    }

    public utilisateur(long id,String nom, String prenom, String email, String adresse,long numeroTelephone,String departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;

        this.numeroTelephone = numeroTelephone;
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroTelephone=" + numeroTelephone +
                ", departement='" + departement + '\'' +
                '}';
    }
}
