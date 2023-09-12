package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Stavka;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Stavka entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {}
