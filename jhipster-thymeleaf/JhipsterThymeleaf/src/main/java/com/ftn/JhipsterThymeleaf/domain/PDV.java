package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

/**
 * A PDV.
 */
@Entity
@Table(name = "pdv")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PDV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pdv")
    private Double pdv;

    @Column(name = "datum_vazenja")
    private Instant datumVazenja;

    @ManyToOne
//    @JsonIgnore
    @JsonIgnoreProperties(value = { "grupas", "pDVS" }, allowSetters = true)
    private KategorijaPDV kategorija;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PDV id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPdv() {
        return this.pdv;
    }

    public PDV pdv(Double pdv) {
        this.setPdv(pdv);
        return this;
    }

    public void setPdv(Double pdv) {
        this.pdv = pdv;
    }

    public Instant getDatumVazenja() {
        return this.datumVazenja;
    }

    public PDV datumVazenja(Instant datumVazenja) {
        this.setDatumVazenja(datumVazenja);
        return this;
    }

    public void setDatumVazenja(Instant datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public KategorijaPDV getKategorija() {
        return this.kategorija;
    }

    public void setKategorija(KategorijaPDV kategorijaPDV) {
        this.kategorija = kategorijaPDV;
    }

    public PDV kategorija(KategorijaPDV kategorijaPDV) {
        this.setKategorija(kategorijaPDV);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PDV)) {
            return false;
        }
        return id != null && id.equals(((PDV) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PDV{" +
            "id=" + getId() +
            ", pdv=" + getPdv() +
            ", datumVazenja='" + getDatumVazenja() + "'" +
            "}";
    }
}
