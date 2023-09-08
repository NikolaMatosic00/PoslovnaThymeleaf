package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.KategorijaPDV;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the KategorijaPDV entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KategorijaPDVRepository extends JpaRepository<KategorijaPDV, Long> {}
