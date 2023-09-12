package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.PDV;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PDV entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PDVRepository extends JpaRepository<PDV, Long> {}
