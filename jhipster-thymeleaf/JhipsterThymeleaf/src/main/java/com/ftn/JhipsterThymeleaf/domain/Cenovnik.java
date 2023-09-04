package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Cenovnik.
 */
@Entity
@Table(name = "cenovnik")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Cenovnik implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "datum_vazenja")
    private Instant datumVazenja;

    @OneToMany(mappedBy = "cenovnik")
    @JsonIgnoreProperties(value = { "stavkas", "grupa", "mera", "cenovnik" }, allowSetters = true)
    private Set<Usluga> uslugas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cenovnik id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatumVazenja() {
        return this.datumVazenja;
    }

    public Cenovnik datumVazenja(Instant datumVazenja) {
        this.setDatumVazenja(datumVazenja);
        return this;
    }

    public void setDatumVazenja(Instant datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public Set<Usluga> getUslugas() {
        return this.uslugas;
    }

    public void setUslugas(Set<Usluga> uslugas) {
        if (this.uslugas != null) {
            this.uslugas.forEach(i -> i.setCenovnik(null));
        }
        if (uslugas != null) {
            uslugas.forEach(i -> i.setCenovnik(this));
        }
        this.uslugas = uslugas;
    }

    public Cenovnik uslugas(Set<Usluga> uslugas) {
        this.setUslugas(uslugas);
        return this;
    }

    public Cenovnik addUsluga(Usluga usluga) {
        this.uslugas.add(usluga);
        usluga.setCenovnik(this);
        return this;
    }

    public Cenovnik removeUsluga(Usluga usluga) {
        this.uslugas.remove(usluga);
        usluga.setCenovnik(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cenovnik)) {
            return false;
        }
        return id != null && id.equals(((Cenovnik) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cenovnik{" +
            "id=" + getId() +
            ", datumVazenja='" + getDatumVazenja() + "'" +
            "}";
    }
}
