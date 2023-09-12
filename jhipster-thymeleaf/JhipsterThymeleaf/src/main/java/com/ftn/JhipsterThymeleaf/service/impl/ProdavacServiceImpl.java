package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Prodavac;
import com.ftn.JhipsterThymeleaf.repository.ProdavacRepository;
import com.ftn.JhipsterThymeleaf.service.ProdavacService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Prodavac}.
 */
@Service
@Transactional
public class ProdavacServiceImpl implements ProdavacService {

    private final Logger log = LoggerFactory.getLogger(ProdavacServiceImpl.class);

    private final ProdavacRepository prodavacRepository;

    public ProdavacServiceImpl(ProdavacRepository prodavacRepository) {
        this.prodavacRepository = prodavacRepository;
    }

    @Override
    public Prodavac save(Prodavac prodavac) {
        log.debug("Request to save Prodavac : {}", prodavac);
        return prodavacRepository.save(prodavac);
    }

    @Override
    public Prodavac update(Prodavac prodavac) {
        log.debug("Request to update Prodavac : {}", prodavac);
        return prodavacRepository.save(prodavac);
    }

    @Override
    public Optional<Prodavac> partialUpdate(Prodavac prodavac) {
        log.debug("Request to partially update Prodavac : {}", prodavac);

        return prodavacRepository
            .findById(prodavac.getId())
            .map(existingProdavac -> {
                if (prodavac.getNaziv() != null) {
                    existingProdavac.setNaziv(prodavac.getNaziv());
                }
                if (prodavac.getAdresa() != null) {
                    existingProdavac.setAdresa(prodavac.getAdresa());
                }
                if (prodavac.getPoreskiIdentifikacioniBroj() != null) {
                    existingProdavac.setPoreskiIdentifikacioniBroj(prodavac.getPoreskiIdentifikacioniBroj());
                }
                if (prodavac.getMaticniBroj() != null) {
                    existingProdavac.setMaticniBroj(prodavac.getMaticniBroj());
                }
                if (prodavac.getZiroRacun() != null) {
                    existingProdavac.setZiroRacun(prodavac.getZiroRacun());
                }

                return existingProdavac;
            })
            .map(prodavacRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Prodavac> findAll() {
        log.debug("Request to get all Prodavacs");
        return prodavacRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Prodavac> findOne(Long id) {
        log.debug("Request to get Prodavac : {}", id);
        return prodavacRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Prodavac : {}", id);
        prodavacRepository.deleteById(id);
    }
}
