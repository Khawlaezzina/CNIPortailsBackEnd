package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class CIChangementId implements Serializable {

    @Column(name="idCI")
    Long idCI;

    @Column(name="idChangement")
    Long idChangement;

    public CIChangementId() {
    }

    public CIChangementId(Long idCI, Long idChangement) {
        this.idCI = idCI;
        this.idChangement = idChangement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CIChangementId that = (CIChangementId) o;
        return Objects.equals(idCI, that.idCI) && Objects.equals(idChangement, that.idChangement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCI, idChangement);
    }
}
