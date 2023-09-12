package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Usluga;
import com.ftn.JhipsterThymeleaf.service.dto.PromenaCenovnikaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Usluga}.
 */
public interface UslugaService {
    /**
     * Save a usluga.
     *
     * @param usluga the entity to save.
     * @return the persisted entity.
     */
    Usluga save(Usluga usluga);

    /**
     * Updates a usluga.
     *
     * @param usluga the entity to update.
     * @return the persisted entity.
     */
    Usluga update(Usluga usluga);

    /**
     * Partially updates a usluga.
     *
     * @param usluga the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Usluga> partialUpdate(Usluga usluga);

    /**
     * Get all the uslugas.
     *
     * @return the list of entities.
     */
    List<Usluga> findAll();

    /**
     * Get the "id" usluga.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Usluga> findOne(Long id);

    /**
     * Delete the "id" usluga.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    void promenaCenovnika(PromenaCenovnikaDTO promena);
}
