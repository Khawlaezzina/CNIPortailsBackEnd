package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class problemeTechnicienId implements Serializable {

    @Column(name="idProbleme")
    Long idProbleme;

    @Column(name="idTechnicien")
    Long idTechnicien;

    public problemeTechnicienId() {
    }

    public problemeTechnicienId(Long idProbleme, Long idTechnicien) {
        this.idProbleme = idProbleme;
        this.idTechnicien = idTechnicien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        problemeTechnicienId that = (problemeTechnicienId) o;
        return Objects.equals(idProbleme, that.idProbleme) && Objects.equals(idTechnicien, that.idTechnicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProbleme, idTechnicien);
    }
}
