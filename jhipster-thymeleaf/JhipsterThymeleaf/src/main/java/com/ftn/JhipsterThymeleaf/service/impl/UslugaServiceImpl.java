package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Usluga;
import com.ftn.JhipsterThymeleaf.repository.UslugaRepository;
import com.ftn.JhipsterThymeleaf.service.UslugaService;


import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.ftn.JhipsterThymeleaf.service.dto.PromenaCenovnikaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ftn.JhipsterThymeleaf.domain.Usluga}.
 */
@Service
@Transactional
public class UslugaServiceImpl implements UslugaService {

    private final Logger log = LoggerFactory.getLogger(UslugaServiceImpl.class);

    private final UslugaRepository uslugaRepository;

    public UslugaServiceImpl(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    @Override
    public Usluga save(Usluga usluga) {
        log.debug("Request to save Usluga : {}", usluga);
        return uslugaRepository.save(usluga);
    }

    @Override
    public Usluga update(Usluga usluga) {
        log.debug("Request to update Usluga : {}", usluga);
        return uslugaRepository.save(usluga);
    }

    @Override
    public Optional<Usluga> partialUpdate(Usluga usluga) {
        log.debug("Request to partially update Usluga : {}", usluga);

        return uslugaRepository
            .findById(usluga.getId())
            .map(existingUsluga -> {
                if (usluga.getNaziv() != null) {
                    existingUsluga.setNaziv(usluga.getNaziv());
                }
                if (usluga.getCena() != null) {
                    existingUsluga.setCena(usluga.getCena());
                }

                return existingUsluga;
            })
            .map(uslugaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usluga> findAll() {
        log.debug("Request to get all Uslugas");
        return uslugaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usluga> findOne(Long id) {
        log.debug("Request to get Usluga : {}", id);
        return uslugaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Usluga : {}", id);
        uslugaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void promenaCenovnika(PromenaCenovnikaDTO promena) {
        List<Usluga> usluge = uslugaRepository.findAll();
        for (Usluga u : usluge) {
            if(u.getCenovnik().getDatumVazenja().isAfter(Instant.now())){
                double cena = u.getCena();
                if (promena.getProcenat() > 0) {
                    cena = cena + Math.abs(((promena.getProcenat() * 1.0 / 100) * cena));
                } else if (promena.getProcenat() < 0) {
                    cena = cena - Math.abs((promena.getProcenat() * 1.0 / 100) * cena);
                }
                DecimalFormat df = new DecimalFormat("#.##");
                u.setCena(Double.valueOf(df.format(cena).replaceAll(",", "")));
                uslugaRepository.save(u);
            }
        }
    }
}
