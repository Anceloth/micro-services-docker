package com.company.authorsservice.domain.entities;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDomain {

	private Long authorId;
	private String authorName;
	private PageableMovies movies;

	public AuthorDomain() {
		this.movies = new PageableMovies();
	}

	public AuthorDomain(Long authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "AuthorDomain [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public PageableMovies getMovies() {
		return movies;
	}

	public void setMovies(PageableMovies movies) {
		this.movies = movies;
	}
	
	
}
