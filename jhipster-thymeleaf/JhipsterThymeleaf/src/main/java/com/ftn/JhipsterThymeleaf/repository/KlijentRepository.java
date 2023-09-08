package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Klijent;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Klijent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KlijentRepository extends JpaRepository<Klijent, Long> {}
