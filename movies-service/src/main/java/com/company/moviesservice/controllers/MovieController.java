package com.company.moviesservice.controllers;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.moviesservice.domain.entities.GetMoviesDTO;
import com.company.moviesservice.domain.entities.Movies;
import com.company.moviesservice.domain.usecases.CreateOrUpdateMovieUseCase;
import com.company.moviesservice.domain.usecases.GetMoviesByAuthorUseCase;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	GetMoviesByAuthorUseCase getMoviesByAuthor;
	
	@Autowired
	CreateOrUpdateMovieUseCase saveMovie;
	
	@GetMapping(value = "/{authorId}")
	public ResponseEntity<Map<String, Object>> getMoviesByAuthor(
			@PathVariable("authorId") Long authorId,
			@RequestParam(required = false) String title,
		    @RequestParam(defaultValue = "0") int page,
		    @RequestParam(defaultValue = "3") int size) {
		
		Map<String, Object> moviesPaginated = new HashMap<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			Pageable pagingSort = PageRequest.of(page, size, Sort.by("movieName"));
			GetMoviesDTO dataDTO = new GetMoviesDTO(authorId, pagingSort);
			moviesPaginated = getMoviesByAuthor.execute(dataDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(moviesPaginated, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/create-update", 
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movies>createOrEditAuthor(@RequestBody Movies movie) {
		Movies moviesResponse = new Movies();;
		try {
			moviesResponse = saveMovie.execute(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Movies>(moviesResponse, HttpStatus.CREATED);
		
	}

}
