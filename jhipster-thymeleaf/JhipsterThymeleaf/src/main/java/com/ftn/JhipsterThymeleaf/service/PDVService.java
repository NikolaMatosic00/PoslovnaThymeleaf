package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.PDV;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PDV}.
 */
public interface PDVService {
    /**
     * Save a pDV.
     *
     * @param pDV the entity to save.
     * @return the persisted entity.
     */
    PDV save(PDV pDV);

    /**
     * Updates a pDV.
     *
     * @param pDV the entity to update.
     * @return the persisted entity.
     */
    PDV update(PDV pDV);

    /**
     * Partially updates a pDV.
     *
     * @param pDV the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PDV> partialUpdate(PDV pDV);

    /**
     * Get all the pDVS.
     *
     * @return the list of entities.
     */
    List<PDV> findAll();

    /**
     * Get the "id" pDV.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PDV> findOne(Long id);

    /**
     * Delete the "id" pDV.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
