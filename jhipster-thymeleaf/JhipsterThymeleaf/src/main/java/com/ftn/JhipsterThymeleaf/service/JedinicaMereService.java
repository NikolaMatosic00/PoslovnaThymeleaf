package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.JedinicaMere;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link JedinicaMere}.
 */
public interface JedinicaMereService {
    /**
     * Save a jedinicaMere.
     *
     * @param jedinicaMere the entity to save.
     * @return the persisted entity.
     */
    JedinicaMere save(JedinicaMere jedinicaMere);

    /**
     * Updates a jedinicaMere.
     *
     * @param jedinicaMere the entity to update.
     * @return the persisted entity.
     */
    JedinicaMere update(JedinicaMere jedinicaMere);

    /**
     * Partially updates a jedinicaMere.
     *
     * @param jedinicaMere the entity to update partially.
     * @return the persisted entity.
     */
    Optional<JedinicaMere> partialUpdate(JedinicaMere jedinicaMere);

    /**
     * Get all the jedinicaMeres.
     *
     * @return the list of entities.
     */
    List<JedinicaMere> findAll();

    /**
     * Get the "id" jedinicaMere.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JedinicaMere> findOne(Long id);

    /**
     * Delete the "id" jedinicaMere.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
