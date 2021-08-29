package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class serviceTechnicienId implements Serializable {

    @Column(name="idService")
    Long idService;

    @Column(name="idTechnicien")
    Long idTechnicien;


    public serviceTechnicienId() {
    }

    public serviceTechnicienId(Long idService, Long idTechnicien) {
        this.idService = idService;
        this.idTechnicien = idTechnicien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        serviceTechnicienId that = (serviceTechnicienId) o;
        return Objects.equals(idService, that.idService) && Objects.equals(idTechnicien, that.idTechnicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, idTechnicien);
    }
}
