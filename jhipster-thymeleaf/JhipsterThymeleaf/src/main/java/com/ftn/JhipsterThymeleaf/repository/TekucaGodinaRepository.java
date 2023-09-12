package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.TekucaGodina;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TekucaGodina entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TekucaGodinaRepository extends JpaRepository<TekucaGodina, Long> {}
