package com.company.moviesservice.domain.entities;

import org.springframework.data.domain.Pageable;

public class GetMoviesDTO {
	
	private Long authorId;
	private Pageable pageable;
	
	public GetMoviesDTO() {
		
	}
	
	public GetMoviesDTO(Long authorId, Pageable pageable) {
		super();
		this.authorId = authorId;
		this.pageable = pageable;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	@Override
	public String toString() {
		return "GetMoviesDTO [authorId=" + authorId + ", pageable=" + pageable + "]";
	}

}
