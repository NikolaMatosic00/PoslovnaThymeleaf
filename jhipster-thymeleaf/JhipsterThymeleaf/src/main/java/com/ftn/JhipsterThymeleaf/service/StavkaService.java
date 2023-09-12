package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Stavka;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Stavka}.
 */
public interface StavkaService {
    /**
     * Save a stavka.
     *
     * @param stavka the entity to save.
     * @return the persisted entity.
     */
    Stavka save(Stavka stavka) throws Exception;

    /**
     * Updates a stavka.
     *
     * @param stavka the entity to update.
     * @return the persisted entity.
     */
    Stavka update(Stavka stavka) throws Exception;

    /**
     * Partially updates a stavka.
     *
     * @param stavka the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Stavka> partialUpdate(Stavka stavka);

    /**
     * Get all the stavkas.
     *
     * @return the list of entities.
     */
    List<Stavka> findAll();

    /**
     * Get the "id" stavka.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Stavka> findOne(Long id);

    /**
     * Delete the "id" stavka.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
