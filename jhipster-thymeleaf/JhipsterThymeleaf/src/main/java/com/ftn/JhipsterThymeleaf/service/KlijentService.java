package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Klijent;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Klijent}.
 */
public interface KlijentService {
    /**
     * Save a klijent.
     *
     * @param klijent the entity to save.
     * @return the persisted entity.
     */
    Klijent save(Klijent klijent);

    /**
     * Updates a klijent.
     *
     * @param klijent the entity to update.
     * @return the persisted entity.
     */
    Klijent update(Klijent klijent);

    /**
     * Partially updates a klijent.
     *
     * @param klijent the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Klijent> partialUpdate(Klijent klijent);

    /**
     * Get all the klijents.
     *
     * @return the list of entities.
     */
    List<Klijent> findAll();

    /**
     * Get the "id" klijent.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Klijent> findOne(Long id);

    /**
     * Delete the "id" klijent.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
