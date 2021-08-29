package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class changementTechnicienId implements Serializable {

    @Column(name="idChangement")
    Long idChangement;

    @Column(name="idTechnicien")
    Long idTechnicien;

    public changementTechnicienId() {
    }

    public changementTechnicienId(Long idChangement, Long idTechnicien) {
        this.idChangement = idChangement;
        this.idTechnicien = idTechnicien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        changementTechnicienId that = (changementTechnicienId) o;
        return Objects.equals(idChangement, that.idChangement) && Objects.equals(idTechnicien, that.idTechnicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChangement, idTechnicien);
    }
}
