package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A KategorijaPDV.
 */
@Entity
@Table(name = "kategorija_pdv")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class KategorijaPDV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @OneToMany(mappedBy = "kategorija")
    @JsonIgnoreProperties(value = { "uslugas", "kategorija" }, allowSetters = true)
    private Set<Grupa> grupas = new HashSet<>();

    @OneToMany(mappedBy = "kategorija", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "kategorija" }, allowSetters = true)
    private Set<PDV> pDVS = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public KategorijaPDV id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public KategorijaPDV naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Grupa> getGrupas() {
        return this.grupas;
    }

    public void setGrupas(Set<Grupa> grupas) {
        if (this.grupas != null) {
            this.grupas.forEach(i -> i.setKategorija(null));
        }
        if (grupas != null) {
            grupas.forEach(i -> i.setKategorija(this));
        }
        this.grupas = grupas;
    }

    public KategorijaPDV grupas(Set<Grupa> grupas) {
        this.setGrupas(grupas);
        return this;
    }

    public KategorijaPDV addGrupa(Grupa grupa) {
        this.grupas.add(grupa);
        grupa.setKategorija(this);
        return this;
    }

    public KategorijaPDV removeGrupa(Grupa grupa) {
        this.grupas.remove(grupa);
        grupa.setKategorija(null);
        return this;
    }

    @JsonIgnore
    public Set<PDV> getPDVS() {
        return this.pDVS;
    }

    public void setPDVS(Set<PDV> pDVS) {
        if (this.pDVS != null) {
            this.pDVS.forEach(i -> i.setKategorija(null));
        }
        if (pDVS != null) {
            pDVS.forEach(i -> i.setKategorija(this));
        }
        this.pDVS = pDVS;
    }

    public KategorijaPDV pDVS(Set<PDV> pDVS) {
        this.setPDVS(pDVS);
        return this;
    }

    public KategorijaPDV addPDV(PDV pDV) {
        this.pDVS.add(pDV);
        pDV.setKategorija(this);
        return this;
    }

    public KategorijaPDV removePDV(PDV pDV) {
        this.pDVS.remove(pDV);
        pDV.setKategorija(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KategorijaPDV)) {
            return false;
        }
        return id != null && id.equals(((KategorijaPDV) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "KategorijaPDV{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            "}";
    }
}
