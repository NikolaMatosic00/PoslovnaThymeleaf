package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.Cenovnik;
import com.ftn.JhipsterThymeleaf.repository.CenovnikRepository;
import com.ftn.JhipsterThymeleaf.service.CenovnikService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cenovnik}.
 */
@Service
@Transactional
public class CenovnikServiceImpl implements CenovnikService {

    private final Logger log = LoggerFactory.getLogger(CenovnikServiceImpl.class);

    private final CenovnikRepository cenovnikRepository;

    public CenovnikServiceImpl(CenovnikRepository cenovnikRepository) {
        this.cenovnikRepository = cenovnikRepository;
    }

    @Override
    public Cenovnik save(Cenovnik cenovnik) {
        log.debug("Request to save Cenovnik : {}", cenovnik);
        return cenovnikRepository.save(cenovnik);
    }

    @Override
    public Cenovnik update(Cenovnik cenovnik) {
        log.debug("Request to update Cenovnik : {}", cenovnik);
        return cenovnikRepository.save(cenovnik);
    }

    @Override
    public Optional<Cenovnik> partialUpdate(Cenovnik cenovnik) {
        log.debug("Request to partially update Cenovnik : {}", cenovnik);

        return cenovnikRepository
            .findById(cenovnik.getId())
            .map(existingCenovnik -> {
                if (cenovnik.getDatumVazenja() != null) {
                    existingCenovnik.setDatumVazenja(cenovnik.getDatumVazenja());
                }

                return existingCenovnik;
            })
            .map(cenovnikRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cenovnik> findAll() {
        log.debug("Request to get all Cenovniks");
        return cenovnikRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cenovnik> findOne(Long id) {
        log.debug("Request to get Cenovnik : {}", id);
        return cenovnikRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cenovnik : {}", id);
        cenovnikRepository.deleteById(id);
    }
}
