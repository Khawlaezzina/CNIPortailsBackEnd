package com.example.stage.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class CIProblemeId implements Serializable {

    @Column(name="idCI")
    Long idCI;

    @Column(name="idProbleme")
    Long idProbleme;

    public CIProblemeId() {
    }

    public CIProblemeId(Long idCI, Long idProbleme) {
        this.idCI = idCI;
        this.idProbleme = idProbleme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CIProblemeId that = (CIProblemeId) o;
        return Objects.equals(idCI, that.idCI) && Objects.equals(idProbleme, that.idProbleme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCI, idProbleme);
    }
}
