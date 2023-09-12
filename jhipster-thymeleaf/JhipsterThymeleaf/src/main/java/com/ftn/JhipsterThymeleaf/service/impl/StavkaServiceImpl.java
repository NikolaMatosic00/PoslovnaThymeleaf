package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.PDV;
import com.ftn.JhipsterThymeleaf.domain.Stavka;
import com.ftn.JhipsterThymeleaf.domain.Usluga;
import com.ftn.JhipsterThymeleaf.repository.StavkaRepository;
import com.ftn.JhipsterThymeleaf.repository.UslugaRepository;
import com.ftn.JhipsterThymeleaf.service.StavkaService;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Stavka}.
 */
@Service
@Transactional
public class StavkaServiceImpl implements StavkaService {

    private final Logger log = LoggerFactory.getLogger(StavkaServiceImpl.class);

    private final StavkaRepository stavkaRepository;
    private final UslugaRepository uslugaRepository;

    public StavkaServiceImpl(StavkaRepository stavkaRepository, UslugaRepository uslugaRepository) {
        this.stavkaRepository = stavkaRepository;
        this.uslugaRepository = uslugaRepository;
    }

    @Override
    public Stavka save(Stavka stavka) throws Exception {
        log.debug("Request to save Stavka : {}", stavka);
        log.debug("Request to save Stavka>Usluga : {}", stavka.getUsluga());
        Usluga usluga = uslugaRepository.findById(stavka.getUsluga().getId()).get();
        log.debug("Request to save Stavka>Usluga>Cenovnik : {}", usluga.getCenovnik());
        if(!usluga.getCenovnik().getDatumVazenja().isAfter(Instant.now())){
            throw new Exception("Nevazeci cenovnik");
        }
        double pdv = 0.0;
        for(PDV tmppdv:usluga.getGrupa().getKategorija().getPDVS()){
            if(tmppdv.getDatumVazenja().isAfter(Instant.now())){
                pdv = tmppdv.getPdv();
            }
        }
        stavka.setPdv(pdv);
        stavka.setCena(usluga.getCena());
        if (pdv > 0) {
            stavka.setCenaPlusPDV(usluga.getCena() + ((pdv / 100) * usluga.getCena()));
        } else {
            stavka.setCenaPlusPDV(usluga.getCena());
        }
        stavka.setVrednostRSD(stavka.getKolicina() * stavka.getCenaPlusPDV());
        return stavkaRepository.save(stavka);
    }

    @Override
    public Stavka update(Stavka stavka) throws Exception {
        log.debug("Request to save Stavka : {}", stavka);
        log.debug("Request to save Stavka>Usluga : {}", stavka.getUsluga());
        Usluga usluga = uslugaRepository.findById(stavka.getUsluga().getId()).get();
        log.debug("Request to save Stavka>Usluga>Cenovnik : {}", usluga.getCenovnik());
        if(!usluga.getCenovnik().getDatumVazenja().isAfter(Instant.now())){
            throw new Exception("Nevazeci cenovnik");
        }
        double pdv = 0.0;
        for(PDV tmppdv:usluga.getGrupa().getKategorija().getPDVS()){
            if(tmppdv.getDatumVazenja().isAfter(Instant.now())){
                pdv = tmppdv.getPdv();
            }
        }
        stavka.setPdv(pdv);
        stavka.setCena(stavka.getUsluga().getCena());
        if (pdv > 0) {
            stavka.setCenaPlusPDV(stavka.getUsluga().getCena() + ((pdv / 100) * stavka.getUsluga().getCena()));
        } else {
            stavka.setCenaPlusPDV(stavka.getUsluga().getCena());
        }
        stavka.setVrednostRSD(stavka.getKolicina() * stavka.getCenaPlusPDV());
        return stavkaRepository.save(stavka);
    }

    @Override
    public Optional<Stavka> partialUpdate(Stavka stavka) {
        log.debug("Request to partially update Stavka : {}", stavka);

        return stavkaRepository
            .findById(stavka.getId())
            .map(existingStavka -> {
                if (stavka.getVrstaRobeIliUsluge() != null) {
                    existingStavka.setVrstaRobeIliUsluge(stavka.getVrstaRobeIliUsluge());
                }
                if (stavka.getKolicina() != null) {
                    existingStavka.setKolicina(stavka.getKolicina());
                }
                if (stavka.getCena() != null) {
                    existingStavka.setCena(stavka.getCena());
                }
                if (stavka.getPdv() != null) {
                    existingStavka.setPdv(stavka.getPdv());
                }
                if (stavka.getCenaPlusPDV() != null) {
                    existingStavka.setCenaPlusPDV(stavka.getCenaPlusPDV());
                }
                if (stavka.getVrednostRSD() != null) {
                    existingStavka.setVrednostRSD(stavka.getVrednostRSD());
                }

                return existingStavka;
            })
            .map(stavkaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stavka> findAll() {
        log.debug("Request to get all Stavkas");
        return stavkaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Stavka> findOne(Long id) {
        log.debug("Request to get Stavka : {}", id);
        return stavkaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Stavka : {}", id);
        stavkaRepository.deleteById(id);
    }
}
