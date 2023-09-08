package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Grupa;
import com.ftn.JhipsterThymeleaf.repository.GrupaRepository;
import com.ftn.JhipsterThymeleaf.service.GrupaService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Grupa}.
 */
@Service
@Transactional
public class GrupaServiceImpl implements GrupaService {

    private final Logger log = LoggerFactory.getLogger(GrupaServiceImpl.class);

    private final GrupaRepository grupaRepository;

    public GrupaServiceImpl(GrupaRepository grupaRepository) {
        this.grupaRepository = grupaRepository;
    }

    @Override
    public Grupa save(Grupa grupa) {
        log.debug("Request to save Grupa : {}", grupa);
        return grupaRepository.save(grupa);
    }

    @Override
    public Grupa update(Grupa grupa) {
        log.debug("Request to update Grupa : {}", grupa);
        return grupaRepository.save(grupa);
    }

    @Override
    public Optional<Grupa> partialUpdate(Grupa grupa) {
        log.debug("Request to partially update Grupa : {}", grupa);

        return grupaRepository
            .findById(grupa.getId())
            .map(existingGrupa -> {
                if (grupa.getNaziv() != null) {
                    existingGrupa.setNaziv(grupa.getNaziv());
                }

                return existingGrupa;
            })
            .map(grupaRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Grupa> findAll() {
        log.debug("Request to get all Grupas");
        return grupaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grupa> findOne(Long id) {
        log.debug("Request to get Grupa : {}", id);
        return grupaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Grupa : {}", id);
        grupaRepository.deleteById(id);
    }
}
