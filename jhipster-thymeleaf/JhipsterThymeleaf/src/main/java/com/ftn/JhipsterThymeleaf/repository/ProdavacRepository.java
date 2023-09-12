package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Prodavac;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Prodavac entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdavacRepository extends JpaRepository<Prodavac, Long> {}
