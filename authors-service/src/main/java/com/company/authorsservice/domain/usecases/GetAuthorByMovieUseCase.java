package com.company.authorsservice.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.authorsservice.domain.entities.Author;
import com.company.authorsservice.external.AuthorRepository;


public class GetAuthorByMovieUseCase implements UseCase<String, Author>{
	
	@Autowired
	AuthorRepository authorRepo;

	@Override
	public Author execute(String input) throws Exception {
		
		return authorRepo.save(null);
	}

}
