package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Grupa;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Grupa}.
 */
public interface GrupaService {
    /**
     * Save a grupa.
     *
     * @param grupa the entity to save.
     * @return the persisted entity.
     */
    Grupa save(Grupa grupa);

    /**
     * Updates a grupa.
     *
     * @param grupa the entity to update.
     * @return the persisted entity.
     */
    Grupa update(Grupa grupa);

    /**
     * Partially updates a grupa.
     *
     * @param grupa the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Grupa> partialUpdate(Grupa grupa);

    /**
     * Get all the grupas.
     *
     * @return the list of entities.
     */
    List<Grupa> findAll();

    /**
     * Get the "id" grupa.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Grupa> findOne(Long id);

    /**
     * Delete the "id" grupa.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
