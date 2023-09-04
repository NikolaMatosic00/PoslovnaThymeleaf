package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Klijent.
 */
@Entity
@Table(name = "klijent")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Klijent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "poreski_identifikacioni_broj")
    private String poreskiIdentifikacioniBroj;

    @Column(name = "maticni_broj")
    private String maticniBroj;

    @Column(name = "ziro_racun")
    private String ziroRacun;

    @OneToMany(mappedBy = "klijent")
    @JsonIgnoreProperties(value = { "stavkas", "klijent", "tekucaGodina" }, allowSetters = true)
    private Set<Faktura> fakturas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Klijent id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Klijent naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public Klijent adresa(String adresa) {
        this.setAdresa(adresa);
        return this;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPoreskiIdentifikacioniBroj() {
        return this.poreskiIdentifikacioniBroj;
    }

    public Klijent poreskiIdentifikacioniBroj(String poreskiIdentifikacioniBroj) {
        this.setPoreskiIdentifikacioniBroj(poreskiIdentifikacioniBroj);
        return this;
    }

    public void setPoreskiIdentifikacioniBroj(String poreskiIdentifikacioniBroj) {
        this.poreskiIdentifikacioniBroj = poreskiIdentifikacioniBroj;
    }

    public String getMaticniBroj() {
        return this.maticniBroj;
    }

    public Klijent maticniBroj(String maticniBroj) {
        this.setMaticniBroj(maticniBroj);
        return this;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getZiroRacun() {
        return this.ziroRacun;
    }

    public Klijent ziroRacun(String ziroRacun) {
        this.setZiroRacun(ziroRacun);
        return this;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public Set<Faktura> getFakturas() {
        return this.fakturas;
    }

    public void setFakturas(Set<Faktura> fakturas) {
        if (this.fakturas != null) {
            this.fakturas.forEach(i -> i.setKlijent(null));
        }
        if (fakturas != null) {
            fakturas.forEach(i -> i.setKlijent(this));
        }
        this.fakturas = fakturas;
    }

    public Klijent fakturas(Set<Faktura> fakturas) {
        this.setFakturas(fakturas);
        return this;
    }

    public Klijent addFaktura(Faktura faktura) {
        this.fakturas.add(faktura);
        faktura.setKlijent(this);
        return this;
    }

    public Klijent removeFaktura(Faktura faktura) {
        this.fakturas.remove(faktura);
        faktura.setKlijent(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Klijent)) {
            return false;
        }
        return id != null && id.equals(((Klijent) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Klijent{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", adresa='" + getAdresa() + "'" +
            ", poreskiIdentifikacioniBroj='" + getPoreskiIdentifikacioniBroj() + "'" +
            ", maticniBroj='" + getMaticniBroj() + "'" +
            ", ziroRacun='" + getZiroRacun() + "'" +
            "}";
    }
}
