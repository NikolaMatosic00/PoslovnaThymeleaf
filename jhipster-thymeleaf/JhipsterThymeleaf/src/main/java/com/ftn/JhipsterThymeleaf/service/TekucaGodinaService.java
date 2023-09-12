package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.TekucaGodina;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link TekucaGodina}.
 */
public interface TekucaGodinaService {
    /**
     * Save a tekucaGodina.
     *
     * @param tekucaGodina the entity to save.
     * @return the persisted entity.
     */
    TekucaGodina save(TekucaGodina tekucaGodina);

    /**
     * Updates a tekucaGodina.
     *
     * @param tekucaGodina the entity to update.
     * @return the persisted entity.
     */
    TekucaGodina update(TekucaGodina tekucaGodina);

    /**
     * Partially updates a tekucaGodina.
     *
     * @param tekucaGodina the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TekucaGodina> partialUpdate(TekucaGodina tekucaGodina);

    /**
     * Get all the tekucaGodinas.
     *
     * @return the list of entities.
     */
    List<TekucaGodina> findAll();

    /**
     * Get the "id" tekucaGodina.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TekucaGodina> findOne(Long id);

    /**
     * Delete the "id" tekucaGodina.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
