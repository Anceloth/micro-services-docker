package com.company.moviesservice.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Table(name = "movie")
public class Movies {
	
	@Id
    private Long movieId;
	@Column(name = "movie_name")
    private String movieName;
	@Column(name = "movie_year")
    private Date movieYear;
	@Column(name = "author_id")
	private Long authorId;
	
    public Movies() {
	}
    
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieYear=" + movieYear + ", authorId="
				+ authorId + "]";
	}

	public Movies(Long movieId, String movieName, Date movieYear, Long authorId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.authorId = authorId;
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

	public Date getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(Date movieYear) {
		this.movieYear = movieYear;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

}
