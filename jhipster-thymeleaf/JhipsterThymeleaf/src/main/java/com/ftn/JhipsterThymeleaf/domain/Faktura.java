package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The Employee entity.
 */
@Entity
@Table(name = "faktura")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Faktura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The firstname attribute.
     */
    @Column(name = "datum")
    private Instant datum;

    @Column(name = "interni_broj")
    private String interniBroj;

    @Column(name = "napomena")
    private String napomena;

    @OneToMany(mappedBy = "faktura", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = { "faktura", "usluga" }, allowSetters = true)
    private Set<Stavka> stavkas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "fakturas" }, allowSetters = true)
    private Klijent klijent;

    @ManyToOne
    @JsonIgnoreProperties(value = { "fakturas", "prodava" }, allowSetters = true)
    private TekucaGodina tekucaGodina;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Faktura id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatum() {
        return this.datum;
    }

    public Faktura datum(Instant datum) {
        this.setDatum(datum);
        return this;
    }

    public void setDatum(Instant datum) {
        this.datum = datum;
    }

    public String getInterniBroj() {
        return this.interniBroj;
    }

    public Faktura interniBroj(String interniBroj) {
        this.setInterniBroj(interniBroj);
        return this;
    }

    public void setInterniBroj(String interniBroj) {
        this.interniBroj = interniBroj;
    }

    public String getNapomena() {
        return this.napomena;
    }

    public Faktura napomena(String napomena) {
        this.setNapomena(napomena);
        return this;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Set<Stavka> getStavkas() {
        return this.stavkas;
    }

    public void setStavkas(Set<Stavka> stavkas) {
        if (this.stavkas != null) {
            this.stavkas.forEach(i -> i.setFaktura(null));
        }
        if (stavkas != null) {
            stavkas.forEach(i -> i.setFaktura(this));
        }
        this.stavkas = stavkas;
    }

    public Faktura stavkas(Set<Stavka> stavkas) {
        this.setStavkas(stavkas);
        return this;
    }

    public Faktura addStavka(Stavka stavka) {
        this.stavkas.add(stavka);
        stavka.setFaktura(this);
        return this;
    }

    public Faktura removeStavka(Stavka stavka) {
        this.stavkas.remove(stavka);
        stavka.setFaktura(null);
        return this;
    }

    public Klijent getKlijent() {
        return this.klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Faktura klijent(Klijent klijent) {
        this.setKlijent(klijent);
        return this;
    }

    public TekucaGodina getTekucaGodina() {
        return this.tekucaGodina;
    }

    public void setTekucaGodina(TekucaGodina tekucaGodina) {
        this.tekucaGodina = tekucaGodina;
    }

    public Faktura tekucaGodina(TekucaGodina tekucaGodina) {
        this.setTekucaGodina(tekucaGodina);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Faktura)) {
            return false;
        }
        return id != null && id.equals(((Faktura) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Faktura{" +
            "id=" + getId() +
            ", datum='" + getDatum() + "'" +
            ", interniBroj='" + getInterniBroj() + "'" +
            ", napomena='" + getNapomena() + "'" +
            "}";
    }
}
