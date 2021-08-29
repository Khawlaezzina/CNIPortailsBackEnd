package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class incidentTechnicienId implements Serializable {

    @Column(name="idIncident")
    Long idIncident;

    @Column(name="idTechnicien")
    Long idTechnicien;

    public incidentTechnicienId() {
    }

    public incidentTechnicienId(Long idIncident, Long idTechnicien) {
        this.idIncident = idIncident;
        this.idTechnicien = idTechnicien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        incidentTechnicienId that = (incidentTechnicienId) o;
        return Objects.equals(idIncident, that.idIncident) && Objects.equals(idTechnicien, that.idTechnicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIncident, idTechnicien);
    }
}
