package com.company.authorsservice.domain.usecases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.company.authorsservice.domain.entities.Author;
import com.company.authorsservice.external.AuthorRepository;

@Component(value="autowiredFieldDependency")
public class GetAllAuthorsUseCase implements UseCase<Pageable, Map<String, Object>>{
	
	@Autowired
	AuthorRepository authorRepo;

	@Override
	public Map<String, Object> execute(Pageable pageable) throws Exception {
		List<Author> authors = new ArrayList<Author>();
		Page<Author> authorsPage = authorRepo.findAll(pageable);
		authors = authorsPage.getContent();
		
		Map<String, Object> responsePaginated = new HashMap<>();
		responsePaginated.put("authors", authors);
		responsePaginated.put("currentPage", authorsPage.getNumber());
		responsePaginated.put("totalItems", authorsPage.getTotalElements());
		responsePaginated.put("totalPages", authorsPage.getTotalPages());

		return responsePaginated;
	}

}
