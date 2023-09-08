package com.ftn.JhipsterThymeleaf.service.impl;

import com.ftn.JhipsterThymeleaf.domain.JedinicaMere;
import com.ftn.JhipsterThymeleaf.repository.JedinicaMereRepository;
import com.ftn.JhipsterThymeleaf.service.JedinicaMereService;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link JedinicaMere}.
 */
@Service
@Transactional
public class JedinicaMereServiceImpl implements JedinicaMereService {

    private final Logger log = LoggerFactory.getLogger(JedinicaMereServiceImpl.class);

    private final JedinicaMereRepository jedinicaMereRepository;

    public JedinicaMereServiceImpl(JedinicaMereRepository jedinicaMereRepository) {
        this.jedinicaMereRepository = jedinicaMereRepository;
    }

    @Override
    public JedinicaMere save(JedinicaMere jedinicaMere) {
        log.debug("Request to save JedinicaMere : {}", jedinicaMere);
        return jedinicaMereRepository.save(jedinicaMere);
    }

    @Override
    public JedinicaMere update(JedinicaMere jedinicaMere) {
        log.debug("Request to update JedinicaMere : {}", jedinicaMere);
        return jedinicaMereRepository.save(jedinicaMere);
    }

    @Override
    public Optional<JedinicaMere> partialUpdate(JedinicaMere jedinicaMere) {
        log.debug("Request to partially update JedinicaMere : {}", jedinicaMere);

        return jedinicaMereRepository
            .findById(jedinicaMere.getId())
            .map(existingJedinicaMere -> {
                if (jedinicaMere.getNaziv() != null) {
                    existingJedinicaMere.setNaziv(jedinicaMere.getNaziv());
                }

                return existingJedinicaMere;
            })
            .map(jedinicaMereRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JedinicaMere> findAll() {
        log.debug("Request to get all JedinicaMeres");
        return jedinicaMereRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<JedinicaMere> findOne(Long id) {
        log.debug("Request to get JedinicaMere : {}", id);
        return jedinicaMereRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete JedinicaMere : {}", id);
        jedinicaMereRepository.deleteById(id);
    }
}
