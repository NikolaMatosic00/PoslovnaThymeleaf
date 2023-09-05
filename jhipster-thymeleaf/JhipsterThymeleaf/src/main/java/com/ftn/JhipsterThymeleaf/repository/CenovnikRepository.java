package com.ftn.JhipsterThymeleaf.repository;

import com.ftn.JhipsterThymeleaf.domain.Cenovnik;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Cenovnik entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {}
