package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Table(name ="tache")
public class tache {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;

    @Column(name ="numero")

    private int numero;

    @Column(name ="details")
    @NotBlank(message = "Les details de tache est obligatoire")
    private String details;
    @Column(name ="statut")
    private String statut;
    @ManyToOne
    @JoinColumn(name="idChangement")
    private changement idChangement;

    public tache() {
    }

    public tache(long id,int numero, @NotBlank(message = "Les details de tache est obligatoire") String details) {
        this.id = id;
        this.numero = numero;
        this.details = details;
    }

    @Override
    public String toString() {
        return "tache{" +
                "id=" + id +
                ", numero=" + numero +
                ", details='" + details + '\'' +
                ", idChangement=" + idChangement +
                '}';
    }
}
