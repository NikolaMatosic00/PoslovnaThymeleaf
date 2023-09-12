package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Prodavac;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Prodavac}.
 */
public interface ProdavacService {
    /**
     * Save a prodavac.
     *
     * @param prodavac the entity to save.
     * @return the persisted entity.
     */
    Prodavac save(Prodavac prodavac);

    /**
     * Updates a prodavac.
     *
     * @param prodavac the entity to update.
     * @return the persisted entity.
     */
    Prodavac update(Prodavac prodavac);

    /**
     * Partially updates a prodavac.
     *
     * @param prodavac the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Prodavac> partialUpdate(Prodavac prodavac);

    /**
     * Get all the prodavacs.
     *
     * @return the list of entities.
     */
    List<Prodavac> findAll();

    /**
     * Get the "id" prodavac.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Prodavac> findOne(Long id);

    /**
     * Delete the "id" prodavac.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
