package com.company.authorsservice.domain.usecases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.authorsservice.domain.entities.Author;
import com.company.authorsservice.external.AuthorRepository;

@Component
public class GetAuthorByIdUseCase implements UseCase<Long, Author>{
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Override
	public Author execute(Long id) throws Exception {
		Author author = authorRepo.getReferenceById(id);
		System.out.println("Author: "+ author.toString());
		return author;
	}
	
}
