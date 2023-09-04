package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A JedinicaMere.
 */
@Entity
@Table(name = "jedinica_mere")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class JedinicaMere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @OneToMany(mappedBy = "mera")
    @JsonIgnoreProperties(value = { "stavkas", "grupa", "mera", "cenovnik" }, allowSetters = true)
    private Set<Usluga> uslugas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public JedinicaMere id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public JedinicaMere naziv(String naziv) {
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
            this.uslugas.forEach(i -> i.setMera(null));
        }
        if (uslugas != null) {
            uslugas.forEach(i -> i.setMera(this));
        }
        this.uslugas = uslugas;
    }

    public JedinicaMere uslugas(Set<Usluga> uslugas) {
        this.setUslugas(uslugas);
        return this;
    }

    public JedinicaMere addUsluga(Usluga usluga) {
        this.uslugas.add(usluga);
        usluga.setMera(this);
        return this;
    }

    public JedinicaMere removeUsluga(Usluga usluga) {
        this.uslugas.remove(usluga);
        usluga.setMera(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JedinicaMere)) {
            return false;
        }
        return id != null && id.equals(((JedinicaMere) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JedinicaMere{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            "}";
    }
}
