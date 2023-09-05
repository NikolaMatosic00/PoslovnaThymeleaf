package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Cenovnik;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Cenovnik}.
 */
public interface CenovnikService {
    /**
     * Save a cenovnik.
     *
     * @param cenovnik the entity to save.
     * @return the persisted entity.
     */
    Cenovnik save(Cenovnik cenovnik);

    /**
     * Updates a cenovnik.
     *
     * @param cenovnik the entity to update.
     * @return the persisted entity.
     */
    Cenovnik update(Cenovnik cenovnik);

    /**
     * Partially updates a cenovnik.
     *
     * @param cenovnik the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Cenovnik> partialUpdate(Cenovnik cenovnik);

    /**
     * Get all the cenovniks.
     *
     * @return the list of entities.
     */
    List<Cenovnik> findAll();

    /**
     * Get the "id" cenovnik.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Cenovnik> findOne(Long id);

    /**
     * Delete the "id" cenovnik.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
