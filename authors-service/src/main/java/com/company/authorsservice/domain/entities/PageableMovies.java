package com.company.authorsservice.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "movies")
public class PageableMovies {
	@JsonProperty("movieList")
	public List<MoviesDomain> movies;
	@JsonProperty("currentPage")
	public int currentPage;
	@JsonProperty("totalItems")
	public int totalItems;
	@JsonProperty("totalPages")
	public int totalPages;
	
	@JsonCreator
	public PageableMovies(){
        super();
        this.movies = new ArrayList<>();
	}

	
	@JsonCreator
	public PageableMovies( 
			@JsonProperty("currentPage") int currentPage,
			@JsonProperty("totalItems") int totalItems,
			@JsonProperty("totalPages") int totalPages,
			@JsonProperty("movieList") List<MoviesDomain> movies){
        super();
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.movies = movies;
	}	

}
