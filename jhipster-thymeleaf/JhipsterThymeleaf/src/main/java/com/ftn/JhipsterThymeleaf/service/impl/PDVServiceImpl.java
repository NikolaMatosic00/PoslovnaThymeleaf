package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.PDV;
import com.ftn.JhipsterThymeleaf.repository.PDVRepository;
import com.ftn.JhipsterThymeleaf.service.PDVService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PDV}.
 */
@Service
@Transactional
public class PDVServiceImpl implements PDVService {

    private final Logger log = LoggerFactory.getLogger(PDVServiceImpl.class);

    private final PDVRepository pDVRepository;

    public PDVServiceImpl(PDVRepository pDVRepository) {
        this.pDVRepository = pDVRepository;
    }

    @Override
    public PDV save(PDV pDV) {
        log.debug("Request to save PDV : {}", pDV);
        return pDVRepository.save(pDV);
    }

    @Override
    public PDV update(PDV pDV) {
        log.debug("Request to update PDV : {}", pDV);
        return pDVRepository.save(pDV);
    }

    @Override
    public Optional<PDV> partialUpdate(PDV pDV) {
        log.debug("Request to partially update PDV : {}", pDV);

        return pDVRepository
            .findById(pDV.getId())
            .map(existingPDV -> {
                if (pDV.getPdv() != null) {
                    existingPDV.setPdv(pDV.getPdv());
                }
                if (pDV.getDatumVazenja() != null) {
                    existingPDV.setDatumVazenja(pDV.getDatumVazenja());
                }

                return existingPDV;
            })
            .map(pDVRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PDV> findAll() {
        log.debug("Request to get all PDVS");
        return pDVRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PDV> findOne(Long id) {
        log.debug("Request to get PDV : {}", id);
        return pDVRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PDV : {}", id);
        pDVRepository.deleteById(id);
    }
}
