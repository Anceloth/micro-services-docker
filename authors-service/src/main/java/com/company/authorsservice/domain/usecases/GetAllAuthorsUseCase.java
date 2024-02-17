package com.company.authorsservice.domain.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.company.authorsservice.external.AuthorRepository;
import com.company.authorsservice.external.entities.Author;
import com.company.authorsservice.domain.entities.AuthorDomain;
import com.company.authorsservice.domain.entities.MoviesDomain;

@Component(value="autowiredFieldDependency")
public class GetAllAuthorsUseCase implements UseCase<Pageable, Map<String, Object>>{
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Map<String, Object> execute(Pageable pageable) throws Exception {
		List<AuthorDomain> authors = new ArrayList<AuthorDomain>();
		Page<Author> authorsPage = authorRepo.findAll(pageable);
		List<Author> authorsJpa = new ArrayList<>();
		authorsJpa = authorsPage.getContent();
		
		for (Author author : authorsJpa) {
			AuthorDomain authorDomain = new AuthorDomain(author.getAuthorId(), author.getAuthorName());
			authors.add(authorDomain);
		}
		
		Map<String, Object> responsePaginated = new HashMap<>();
		responsePaginated.put("authors", authors);
		responsePaginated.put("currentPage", authorsPage.getNumber());
		responsePaginated.put("totalItems", authorsPage.getTotalElements());
		responsePaginated.put("totalPages", authorsPage.getTotalPages());

		return responsePaginated;
	}

}
