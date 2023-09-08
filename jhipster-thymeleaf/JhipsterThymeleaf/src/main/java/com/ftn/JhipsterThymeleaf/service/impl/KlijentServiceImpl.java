package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Klijent;
import com.ftn.JhipsterThymeleaf.repository.KlijentRepository;
import com.ftn.JhipsterThymeleaf.service.KlijentService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Klijent}.
 */
@Service
@Transactional
public class KlijentServiceImpl implements KlijentService {

    private final Logger log = LoggerFactory.getLogger(KlijentServiceImpl.class);

    private final KlijentRepository klijentRepository;

    public KlijentServiceImpl(KlijentRepository klijentRepository) {
        this.klijentRepository = klijentRepository;
    }

    @Override
    public Klijent save(Klijent klijent) {
        log.debug("Request to save Klijent : {}", klijent);
        return klijentRepository.save(klijent);
    }

    @Override
    public Klijent update(Klijent klijent) {
        log.debug("Request to update Klijent : {}", klijent);
        return klijentRepository.save(klijent);
    }

    @Override
    public Optional<Klijent> partialUpdate(Klijent klijent) {
        log.debug("Request to partially update Klijent : {}", klijent);

        return klijentRepository
            .findById(klijent.getId())
            .map(existingKlijent -> {
                if (klijent.getNaziv() != null) {
                    existingKlijent.setNaziv(klijent.getNaziv());
                }
                if (klijent.getAdresa() != null) {
                    existingKlijent.setAdresa(klijent.getAdresa());
                }
                if (klijent.getPoreskiIdentifikacioniBroj() != null) {
                    existingKlijent.setPoreskiIdentifikacioniBroj(klijent.getPoreskiIdentifikacioniBroj());
                }
                if (klijent.getMaticniBroj() != null) {
                    existingKlijent.setMaticniBroj(klijent.getMaticniBroj());
                }
                if (klijent.getZiroRacun() != null) {
                    existingKlijent.setZiroRacun(klijent.getZiroRacun());
                }

                return existingKlijent;
            })
            .map(klijentRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Klijent> findAll() {
        log.debug("Request to get all Klijents");
        return klijentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Klijent> findOne(Long id) {
        log.debug("Request to get Klijent : {}", id);
        return klijentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Klijent : {}", id);
        klijentRepository.deleteById(id);
    }
}
