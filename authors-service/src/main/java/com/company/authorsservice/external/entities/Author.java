package com.company.authorsservice.external.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Author {

	@Id
	private Long authorId;
	private String authorName;
	
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
	   // @GeneratedValue(strategy = GenerationType.AUTO)
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
