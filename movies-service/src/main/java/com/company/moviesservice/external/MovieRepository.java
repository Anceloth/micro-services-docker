package com.company.moviesservice.external;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.moviesservice.domain.entities.Movies;


	
@Repository
public interface MovieRepository  extends JpaRepository<Movies, Long> {

	Page<Movies> findAll(Pageable pageable);
	
	@Query(value = "FROM Movies m WHERE m.authorId=?1")
	Page<Movies> findByAuthorId(Long auhorId, Pageable pageable);
}


