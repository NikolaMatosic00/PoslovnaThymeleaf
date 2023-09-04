package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Grupa.
 */
@Entity
@Table(name = "grupa")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Grupa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @OneToMany(mappedBy = "grupa")
    @JsonIgnoreProperties(value = { "stavkas", "grupa", "mera", "cenovnik" }, allowSetters = true)
    private Set<Usluga> uslugas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "grupas", "pDVS" }, allowSetters = true)
    private KategorijaPDV kategorija;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Grupa id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Grupa naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<Usluga> getUslugas() {
        return this.uslugas;
    }

    public void setUslugas(Set<Usluga> uslugas) {
        if (this.uslugas != null) {
            this.uslugas.forEach(i -> i.setGrupa(null));
        }
        if (uslugas != null) {
            uslugas.forEach(i -> i.setGrupa(this));
        }
        this.uslugas = uslugas;
    }

    public Grupa uslugas(Set<Usluga> uslugas) {
        this.setUslugas(uslugas);
        return this;
    }

    public Grupa addUsluga(Usluga usluga) {
        this.uslugas.add(usluga);
        usluga.setGrupa(this);
        return this;
    }

    public Grupa removeUsluga(Usluga usluga) {
        this.uslugas.remove(usluga);
        usluga.setGrupa(null);
        return this;
    }

    public KategorijaPDV getKategorija() {
        return this.kategorija;
    }

    public void setKategorija(KategorijaPDV kategorijaPDV) {
        this.kategorija = kategorijaPDV;
    }

    public Grupa kategorija(KategorijaPDV kategorijaPDV) {
        this.setKategorija(kategorijaPDV);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Grupa)) {
            return false;
        }
        return id != null && id.equals(((Grupa) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Grupa{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            "}";
    }
}
