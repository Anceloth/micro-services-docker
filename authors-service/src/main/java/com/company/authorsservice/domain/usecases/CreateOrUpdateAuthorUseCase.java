package com.company.authorsservice.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.authorsservice.external.AuthorRepository;
import com.company.authorsservice.external.entities.Author;

@Component()
public class CreateOrUpdateAuthorUseCase implements UseCase<Author, Author>{
	
	@Autowired
	AuthorRepository authorRepo;

	@Override
	public Author execute(Author author) throws Exception {
		
		return authorRepo.save(author);
	}

}
