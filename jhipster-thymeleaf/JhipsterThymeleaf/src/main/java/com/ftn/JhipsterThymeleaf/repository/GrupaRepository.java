package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Grupa;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Grupa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {}
