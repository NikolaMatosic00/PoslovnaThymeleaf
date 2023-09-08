package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.KategorijaPDV;
import com.ftn.JhipsterThymeleaf.repository.KategorijaPDVRepository;
import com.ftn.JhipsterThymeleaf.service.KategorijaPDVService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link KategorijaPDV}.
 */
@Service
@Transactional
public class KategorijaPDVServiceImpl implements KategorijaPDVService {

    private final Logger log = LoggerFactory.getLogger(KategorijaPDVServiceImpl.class);

    private final KategorijaPDVRepository kategorijaPDVRepository;

    public KategorijaPDVServiceImpl(KategorijaPDVRepository kategorijaPDVRepository) {
        this.kategorijaPDVRepository = kategorijaPDVRepository;
    }

    @Override
    public KategorijaPDV save(KategorijaPDV kategorijaPDV) {
        log.debug("Request to save KategorijaPDV : {}", kategorijaPDV);
        return kategorijaPDVRepository.save(kategorijaPDV);
    }

    @Override
    public KategorijaPDV update(KategorijaPDV kategorijaPDV) {
        log.debug("Request to update KategorijaPDV : {}", kategorijaPDV);
        return kategorijaPDVRepository.save(kategorijaPDV);
    }

    @Override
    public Optional<KategorijaPDV> partialUpdate(KategorijaPDV kategorijaPDV) {
        log.debug("Request to partially update KategorijaPDV : {}", kategorijaPDV);

        return kategorijaPDVRepository
            .findById(kategorijaPDV.getId())
            .map(existingKategorijaPDV -> {
                if (kategorijaPDV.getNaziv() != null) {
                    existingKategorijaPDV.setNaziv(kategorijaPDV.getNaziv());
                }

                return existingKategorijaPDV;
            })
            .map(kategorijaPDVRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KategorijaPDV> findAll() {
        log.debug("Request to get all KategorijaPDVS");
        return kategorijaPDVRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<KategorijaPDV> findOne(Long id) {
        log.debug("Request to get KategorijaPDV : {}", id);
        return kategorijaPDVRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete KategorijaPDV : {}", id);
        kategorijaPDVRepository.deleteById(id);
    }
}
