package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Usluga;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Usluga entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UslugaRepository extends JpaRepository<Usluga, Long> {}
