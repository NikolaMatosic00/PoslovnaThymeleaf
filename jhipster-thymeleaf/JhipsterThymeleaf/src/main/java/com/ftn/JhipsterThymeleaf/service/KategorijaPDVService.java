package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.KategorijaPDV;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link KategorijaPDV}.
 */
public interface KategorijaPDVService {
    /**
     * Save a kategorijaPDV.
     *
     * @param kategorijaPDV the entity to save.
     * @return the persisted entity.
     */
    KategorijaPDV save(KategorijaPDV kategorijaPDV);

    /**
     * Updates a kategorijaPDV.
     *
     * @param kategorijaPDV the entity to update.
     * @return the persisted entity.
     */
    KategorijaPDV update(KategorijaPDV kategorijaPDV);

    /**
     * Partially updates a kategorijaPDV.
     *
     * @param kategorijaPDV the entity to update partially.
     * @return the persisted entity.
     */
    Optional<KategorijaPDV> partialUpdate(KategorijaPDV kategorijaPDV);

    /**
     * Get all the kategorijaPDVS.
     *
     * @return the list of entities.
     */
    List<KategorijaPDV> findAll();

    /**
     * Get the "id" kategorijaPDV.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<KategorijaPDV> findOne(Long id);

    /**
     * Delete the "id" kategorijaPDV.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
