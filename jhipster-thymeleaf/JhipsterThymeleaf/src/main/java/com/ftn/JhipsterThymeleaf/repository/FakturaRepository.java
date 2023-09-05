package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Faktura;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Spring Data JPA repository for the Faktura entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Long> {
    List<Faktura> findAllByDatumIsBetween(Instant from, Instant to);
}
