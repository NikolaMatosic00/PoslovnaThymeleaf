package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Faktura;
import com.ftn.JhipsterThymeleaf.repository.FakturaRepository;
import com.ftn.JhipsterThymeleaf.service.FakturaService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Faktura}.
 */
@Service
@Transactional
public class FakturaServiceImpl implements FakturaService {

    private final Logger log = LoggerFactory.getLogger(FakturaServiceImpl.class);

    private final FakturaRepository fakturaRepository;

    public FakturaServiceImpl(FakturaRepository fakturaRepository) {
        this.fakturaRepository = fakturaRepository;
    }

    @Override
    @Transactional
    public Faktura save(Faktura faktura) {
        log.debug("Request to save Faktura : {}", faktura);
        return fakturaRepository.save(faktura);
    }

    @Override
    public Faktura update(Faktura faktura) {
        log.debug("Request to update Faktura : {}", faktura);
        return fakturaRepository.save(faktura);
    }

    @Override
    public Optional<Faktura> partialUpdate(Faktura faktura) {
        log.debug("Request to partially update Faktura : {}", faktura);

        return fakturaRepository
            .findById(faktura.getId())
            .map(existingFaktura -> {
                if (faktura.getDatum() != null) {
                    existingFaktura.setDatum(faktura.getDatum());
                }
                if (faktura.getInterniBroj() != null) {
                    existingFaktura.setInterniBroj(faktura.getInterniBroj());
                }
                if (faktura.getNapomena() != null) {
                    existingFaktura.setNapomena(faktura.getNapomena());
                }

                return existingFaktura;
            })
            .map(fakturaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Faktura> findAll() {
        log.debug("Request to get all Fakturas");
        return fakturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Faktura> findOne(Long id) {
        log.debug("Request to get Faktura : {}", id);
        return fakturaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Faktura : {}", id);
        fakturaRepository.deleteById(id);
    }
}
