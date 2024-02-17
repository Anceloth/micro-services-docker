package com.company.authorsservice.domain.entities;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class MoviesDomain {
	
	@JsonProperty("movieId")
    public Long movieId;
	@JsonProperty("movieName")
    public String movieName;
	@JsonProperty("movieYear")
	public String movieYear;
	
    public MoviesDomain() {
	}
    
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieYear=" + movieYear + "]";
	}
	
	@JsonCreator
	public MoviesDomain(@JsonProperty("movieId") Long movieId, @JsonProperty("movieName") String movieName, @JsonProperty("movieYear") String movieYear) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}
}

