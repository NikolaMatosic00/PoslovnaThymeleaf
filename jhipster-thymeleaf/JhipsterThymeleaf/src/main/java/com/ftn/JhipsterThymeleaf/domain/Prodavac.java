package com.ftn.JhipsterThymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Prodavac.
 */
@Entity
@Table(name = "prodavac")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Prodavac implements Serializable {

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

    @OneToMany(mappedBy = "prodava")
    @JsonIgnoreProperties(value = { "fakturas", "prodava" }, allowSetters = true)
    private Set<TekucaGodina> tekucaGodinas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Prodavac id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Prodavac naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return this.adresa;
    }

    public Prodavac adresa(String adresa) {
        this.setAdresa(adresa);
        return this;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPoreskiIdentifikacioniBroj() {
        return this.poreskiIdentifikacioniBroj;
    }

    public Prodavac poreskiIdentifikacioniBroj(String poreskiIdentifikacioniBroj) {
        this.setPoreskiIdentifikacioniBroj(poreskiIdentifikacioniBroj);
        return this;
    }

    public void setPoreskiIdentifikacioniBroj(String poreskiIdentifikacioniBroj) {
        this.poreskiIdentifikacioniBroj = poreskiIdentifikacioniBroj;
    }

    public String getMaticniBroj() {
        return this.maticniBroj;
    }

    public Prodavac maticniBroj(String maticniBroj) {
        this.setMaticniBroj(maticniBroj);
        return this;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getZiroRacun() {
        return this.ziroRacun;
    }

    public Prodavac ziroRacun(String ziroRacun) {
        this.setZiroRacun(ziroRacun);
        return this;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public Set<TekucaGodina> getTekucaGodinas() {
        return this.tekucaGodinas;
    }

    public void setTekucaGodinas(Set<TekucaGodina> tekucaGodinas) {
        if (this.tekucaGodinas != null) {
            this.tekucaGodinas.forEach(i -> i.setProdava(null));
        }
        if (tekucaGodinas != null) {
            tekucaGodinas.forEach(i -> i.setProdava(this));
        }
        this.tekucaGodinas = tekucaGodinas;
    }

    public Prodavac tekucaGodinas(Set<TekucaGodina> tekucaGodinas) {
        this.setTekucaGodinas(tekucaGodinas);
        return this;
    }

    public Prodavac addTekucaGodina(TekucaGodina tekucaGodina) {
        this.tekucaGodinas.add(tekucaGodina);
        tekucaGodina.setProdava(this);
        return this;
    }

    public Prodavac removeTekucaGodina(TekucaGodina tekucaGodina) {
        this.tekucaGodinas.remove(tekucaGodina);
        tekucaGodina.setProdava(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prodavac)) {
            return false;
        }
        return id != null && id.equals(((Prodavac) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Prodavac{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", adresa='" + getAdresa() + "'" +
            ", poreskiIdentifikacioniBroj='" + getPoreskiIdentifikacioniBroj() + "'" +
            ", maticniBroj='" + getMaticniBroj() + "'" +
            ", ziroRacun='" + getZiroRacun() + "'" +
            "}";
    }
}
