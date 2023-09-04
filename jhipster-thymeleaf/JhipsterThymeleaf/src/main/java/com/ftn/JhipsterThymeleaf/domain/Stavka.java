package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A Stavka.
 */
@Entity
@Table(name = "stavka")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vrsta_robe_ili_usluge")
    private String vrstaRobeIliUsluge;

    @Column(name = "kolicina")
    private Long kolicina;

    @Column(name = "cena")
    private Double cena;

    @Column(name = "pdv")
    private Double pdv;

    @Column(name = "cena_plus_pdv")
    private Double cenaPlusPDV;

    @Column(name = "vrednost_rsd")
    private Double vrednostRSD;

    @ManyToOne
    @JsonIgnoreProperties(value = { "stavkas", "klijent", "tekucaGodina" }, allowSetters = true)
    private Faktura faktura;

    @ManyToOne
    @JsonIgnoreProperties(value = { "stavkas", "grupa", "mera", "cenovnik" }, allowSetters = true)
    private Usluga usluga;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Stavka id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVrstaRobeIliUsluge() {
        return this.vrstaRobeIliUsluge;
    }

    public Stavka vrstaRobeIliUsluge(String vrstaRobeIliUsluge) {
        this.setVrstaRobeIliUsluge(vrstaRobeIliUsluge);
        return this;
    }

    public void setVrstaRobeIliUsluge(String vrstaRobeIliUsluge) {
        this.vrstaRobeIliUsluge = vrstaRobeIliUsluge;
    }

    public Long getKolicina() {
        return this.kolicina;
    }

    public Stavka kolicina(Long kolicina) {
        this.setKolicina(kolicina);
        return this;
    }

    public void setKolicina(Long kolicina) {
        this.kolicina = kolicina;
    }

    public Double getCena() {
        return this.cena;
    }

    public Stavka cena(Double cena) {
        this.setCena(cena);
        return this;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Double getPdv() {
        return this.pdv;
    }

    public Stavka pdv(Double pdv) {
        this.setPdv(pdv);
        return this;
    }

    public void setPdv(Double pdv) {
        this.pdv = pdv;
    }

    public Double getCenaPlusPDV() {
        return this.cenaPlusPDV;
    }

    public Stavka cenaPlusPDV(Double cenaPlusPDV) {
        this.setCenaPlusPDV(cenaPlusPDV);
        return this;
    }

    public void setCenaPlusPDV(Double cenaPlusPDV) {
        this.cenaPlusPDV = cenaPlusPDV;
    }

    public Double getVrednostRSD() {
        return this.vrednostRSD;
    }

    public Stavka vrednostRSD(Double vrednostRSD) {
        this.setVrednostRSD(vrednostRSD);
        return this;
    }

    public void setVrednostRSD(Double vrednostRSD) {
        this.vrednostRSD = vrednostRSD;
    }

    public Faktura getFaktura() {
        return this.faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public Stavka faktura(Faktura faktura) {
        this.setFaktura(faktura);
        return this;
    }

    public Usluga getUsluga() {
        return this.usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Stavka usluga(Usluga usluga) {
        this.setUsluga(usluga);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stavka)) {
            return false;
        }
        return id != null && id.equals(((Stavka) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Stavka{" +
            "id=" + getId() +
            ", vrstaRobeIliUsluge='" + getVrstaRobeIliUsluge() + "'" +
            ", kolicina=" + getKolicina() +
            ", cena=" + getCena() +
            ", pdv=" + getPdv() +
            ", cenaPlusPDV=" + getCenaPlusPDV() +
            ", vrednostRSD=" + getVrednostRSD() +
            "}";
    }
}
