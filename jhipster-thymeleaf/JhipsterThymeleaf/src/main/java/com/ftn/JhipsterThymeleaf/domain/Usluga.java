package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Usluga.
 */
@Entity
@Table(name = "usluga")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Usluga implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "cena")
    private Double cena;

    @OneToMany(mappedBy = "usluga")
    @JsonIgnoreProperties(value = { "faktura", "usluga" }, allowSetters = true)
    private Set<Stavka> stavkas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "uslugas", "kategorija" }, allowSetters = true)
    private Grupa grupa;

    @ManyToOne
    @JsonIgnoreProperties(value = { "uslugas" }, allowSetters = true)
    private JedinicaMere mera;

    @ManyToOne
    @JsonIgnoreProperties(value = { "uslugas" }, allowSetters = true)
    private Cenovnik cenovnik;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Usluga id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Usluga naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return this.cena;
    }

    public Usluga cena(Double cena) {
        this.setCena(cena);
        return this;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Set<Stavka> getStavkas() {
        return this.stavkas;
    }

    public void setStavkas(Set<Stavka> stavkas) {
        if (this.stavkas != null) {
            this.stavkas.forEach(i -> i.setUsluga(null));
        }
        if (stavkas != null) {
            stavkas.forEach(i -> i.setUsluga(this));
        }
        this.stavkas = stavkas;
    }

    public Usluga stavkas(Set<Stavka> stavkas) {
        this.setStavkas(stavkas);
        return this;
    }

    public Usluga addStavka(Stavka stavka) {
        this.stavkas.add(stavka);
        stavka.setUsluga(this);
        return this;
    }

    public Usluga removeStavka(Stavka stavka) {
        this.stavkas.remove(stavka);
        stavka.setUsluga(null);
        return this;
    }

    public Grupa getGrupa() {
        return this.grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Usluga grupa(Grupa grupa) {
        this.setGrupa(grupa);
        return this;
    }

    public JedinicaMere getMera() {
        return this.mera;
    }

    public void setMera(JedinicaMere jedinicaMere) {
        this.mera = jedinicaMere;
    }

    public Usluga mera(JedinicaMere jedinicaMere) {
        this.setMera(jedinicaMere);
        return this;
    }

    public Cenovnik getCenovnik() {
        return this.cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public Usluga cenovnik(Cenovnik cenovnik) {
        this.setCenovnik(cenovnik);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usluga)) {
            return false;
        }
        return id != null && id.equals(((Usluga) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Usluga{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", cena=" + getCena() +
            "}";
    }
}
