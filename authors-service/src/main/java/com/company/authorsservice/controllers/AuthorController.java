package com.company.authorsservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.authorsservice.domain.entities.Author;
import com.company.authorsservice.domain.usecases.CreateOrUpdateAuthorUseCase;
import com.company.authorsservice.domain.usecases.GetAllAuthorsUseCase;

@RestController
@RequestMapping(path = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
	
	@Autowired
	GetAllAuthorsUseCase getAllAuthors;
	@Autowired
	CreateOrUpdateAuthorUseCase saveAuthor;

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
