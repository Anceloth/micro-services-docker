package com.company.authorsservice.domain.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Author {

	@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;
	private String authorName;
	
	/*
	@OneToMany
	@JoinTable(
	        name="movie",
	        joinColumns = {@JoinColumn(referencedColumnName = "authorId")},
	        inverseJoinColumns = {@JoinColumn(referencedColumnName = "movieId")}
	)
	List<Movies> movies;
	*/
	public Author() {
		
	}

	public Author(Long authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
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
	


}
