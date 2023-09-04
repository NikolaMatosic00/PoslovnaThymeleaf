package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A TekucaGodina.
 */
@Entity
@Table(name = "tekuca_godina")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TekucaGodina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @OneToMany(mappedBy = "tekucaGodina")
    @JsonIgnoreProperties(value = { "stavkas", "klijent", "tekucaGodina" }, allowSetters = true)
    private Set<Faktura> fakturas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "tekucaGodinas" }, allowSetters = true)
    private Prodavac prodava;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public TekucaGodina id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public TekucaGodina naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Faktura> getFakturas() {
        return this.fakturas;
    }

    public void setFakturas(Set<Faktura> fakturas) {
        if (this.fakturas != null) {
            this.fakturas.forEach(i -> i.setTekucaGodina(null));
        }
        if (fakturas != null) {
            fakturas.forEach(i -> i.setTekucaGodina(this));
        }
        this.fakturas = fakturas;
    }

    public TekucaGodina fakturas(Set<Faktura> fakturas) {
        this.setFakturas(fakturas);
        return this;
    }

    public TekucaGodina addFaktura(Faktura faktura) {
        this.fakturas.add(faktura);
        faktura.setTekucaGodina(this);
        return this;
    }

    public TekucaGodina removeFaktura(Faktura faktura) {
        this.fakturas.remove(faktura);
        faktura.setTekucaGodina(null);
        return this;
    }

    public Prodavac getProdava() {
        return this.prodava;
    }

    public void setProdava(Prodavac prodavac) {
        this.prodava = prodavac;
    }

    public TekucaGodina prodava(Prodavac prodavac) {
        this.setProdava(prodavac);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TekucaGodina)) {
            return false;
        }
        return id != null && id.equals(((TekucaGodina) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TekucaGodina{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            "}";
    }
}
