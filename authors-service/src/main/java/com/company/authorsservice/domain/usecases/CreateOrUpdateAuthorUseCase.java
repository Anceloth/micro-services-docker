package com.company.authorsservice.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.authorsservice.domain.entities.Author;
import com.company.authorsservice.external.AuthorRepository;

@Component()
public class CreateOrUpdateAuthorUseCase implements UseCase<Author, Author>{
	
	@Autowired
	AuthorRepository authorRepo;

	@Override
	public Author execute(Author author) throws Exception {
		
		return authorRepo.save(author);
	}

}
