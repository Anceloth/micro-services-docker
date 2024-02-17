package com.company.authorsservice.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.company.authorsservice.domain.entities.AuthorDomain;
import com.company.authorsservice.domain.entities.MoviesDomain;
import com.company.authorsservice.domain.entities.PageableMovies;
import com.company.authorsservice.domain.usecases.CreateOrUpdateAuthorUseCase;
import com.company.authorsservice.domain.usecases.GetAllAuthorsUseCase;
import com.company.authorsservice.domain.usecases.GetAuthorByIdUseCase;
import com.company.authorsservice.external.entities.Author;
import com.company.authorsservice.external.entities.Movies;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
	
	@Autowired
	GetAllAuthorsUseCase getAllAuthors;
	@Autowired
	CreateOrUpdateAuthorUseCase saveAuthor;
	
	@Autowired
	GetAuthorByIdUseCase  getAuthorById;


	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAuthors(
			  @RequestParam(required = false) String title,
		      @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "3") int size) {
		
		Map<String, Object> authorsPaginated = new HashMap<>();
		try {
			Pageable pagingSort = PageRequest.of(page, size, Sort.by("authorName"));
			authorsPaginated = getAllAuthors.execute(pagingSort);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(authorsPaginated, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{authorId}")
	public ResponseEntity<AuthorDomain> getAuthorById(@PathVariable("authorId") Long authorId) {
		
		AuthorDomain author= new AuthorDomain();
		try {
			author = getAuthorById.execute(authorId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	


	@PostMapping(path = "/create-update", 
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author>createOrEditAuthor(@RequestBody Author author) {
		Author authorResponse = new Author();;
		try {
			authorResponse = saveAuthor.execute(author);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Author>(authorResponse, HttpStatus.CREATED);
		
	}

}
