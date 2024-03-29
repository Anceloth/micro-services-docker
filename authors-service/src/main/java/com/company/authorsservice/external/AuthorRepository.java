package com.company.authorsservice.external;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.authorsservice.external.entities.Author;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {

	Page<Author> findAll(Pageable pageable);
}
