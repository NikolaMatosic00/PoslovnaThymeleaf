package com.ftn.JhipsterThymeleaf.service;

import com.ftn.JhipsterThymeleaf.domain.Faktura;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Faktura}.
 */
public interface FakturaService {
    /**
     * Save a faktura.
     *
     * @param faktura the entity to save.
     * @return the persisted entity.
     */
    Faktura save(Faktura faktura);

    /**
     * Updates a faktura.
     *
     * @param faktura the entity to update.
     * @return the persisted entity.
     */
    Faktura update(Faktura faktura);

    /**
     * Partially updates a faktura.
     *
     * @param faktura the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Faktura> partialUpdate(Faktura faktura);

    /**
     * Get all the fakturas.
     *
     * @return the list of entities.
     */
    List<Faktura> findAll();

    /**
     * Get the "id" faktura.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Faktura> findOne(Long id);

    /**
     * Delete the "id" faktura.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
