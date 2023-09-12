package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.TekucaGodina;
import com.ftn.JhipsterThymeleaf.repository.TekucaGodinaRepository;
import com.ftn.JhipsterThymeleaf.service.TekucaGodinaService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TekucaGodina}.
 */
@Service
@Transactional
public class TekucaGodinaServiceImpl implements TekucaGodinaService {

    private final Logger log = LoggerFactory.getLogger(TekucaGodinaServiceImpl.class);

    private final TekucaGodinaRepository tekucaGodinaRepository;

    public TekucaGodinaServiceImpl(TekucaGodinaRepository tekucaGodinaRepository) {
        this.tekucaGodinaRepository = tekucaGodinaRepository;
    }

    @Override
    public TekucaGodina save(TekucaGodina tekucaGodina) {
        log.debug("Request to save TekucaGodina : {}", tekucaGodina);
        return tekucaGodinaRepository.save(tekucaGodina);
    }

    @Override
    public TekucaGodina update(TekucaGodina tekucaGodina) {
        log.debug("Request to update TekucaGodina : {}", tekucaGodina);
        return tekucaGodinaRepository.save(tekucaGodina);
    }

    @Override
    public Optional<TekucaGodina> partialUpdate(TekucaGodina tekucaGodina) {
        log.debug("Request to partially update TekucaGodina : {}", tekucaGodina);

        return tekucaGodinaRepository
            .findById(tekucaGodina.getId())
            .map(existingTekucaGodina -> {
                if (tekucaGodina.getNaziv() != null) {
                    existingTekucaGodina.setNaziv(tekucaGodina.getNaziv());
                }

                return existingTekucaGodina;
            })
            .map(tekucaGodinaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TekucaGodina> findAll() {
        log.debug("Request to get all TekucaGodinas");
        return tekucaGodinaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TekucaGodina> findOne(Long id) {
        log.debug("Request to get TekucaGodina : {}", id);
        return tekucaGodinaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TekucaGodina : {}", id);
        tekucaGodinaRepository.deleteById(id);
    }
}
